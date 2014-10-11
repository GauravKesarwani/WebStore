package edu.sjsu.cmpe282.dto;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

import edu.sjsu.cmpe282.domain.CartItem;
import edu.sjsu.cmpe282.domain.Order;
import edu.sjsu.cmpe282.domain.OrderView;
import edu.sjsu.cmpe282.domain.Product;
import edu.sjsu.cmpe282.domain.User;
import edu.sjsu.cmpe282.domain.UserView;

public class UserDao {
	Connection conn = null;
	Statement stmt = null;

	// Constructure with JDBC connection
	public UserDao() {
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			conn = DriverManager.getConnection(
					"jdbc:mysql://shopify.cxtsrcjdmuuz.us-east-1.rds.amazonaws.com:3306/Shopify", "root", "root1985$");
			System.out.println("COnn:" + conn);
		} catch (SQLException e) {
			e.printStackTrace();

		}
	}

	public UserView addUser(User user) {
		UserView uv = new UserView();
		try {

			ResultSet rs;
			stmt = conn.createStatement();
			String query = "Select * from Customer where Emailid = '"
					+ user.getEmail() + "';";
			rs = stmt.executeQuery(query);
			if (rs.next()) {
				System.out.println("Email Already Exists");
				uv.setMessage("Email already exists");
			} else {
				query = "INSERT INTO `Shopify`.`Customer` (`FirstName`, `LastName`, `Emailid`, `Password`) VALUES ('"
						+ user.getFirstName()
						+ "', '"
						+ user.getLastName()
						+ "', '"
						+ user.getEmail()
						+ "', '"
						+ user.getPasswd()
						+ "');";
				stmt.executeUpdate(query);
				System.out.println("New User Created");
				uv.setMessage("User Created");

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uv;
	}

	public UserView checkUser(HttpServletRequest request, User user) {
		ResultSet rs;
		UserView userView = new UserView();
		String origPasswd = null;
		try {
			stmt = conn.createStatement();
			String query = "Select * from Customer where Emailid = '"
					+ user.getEmail() + "';";
			rs = stmt.executeQuery(query);
			
			if (rs.next()) {
				origPasswd = rs.getString("Password");
				if (origPasswd.equals(user.getPasswd())) {
					userView = new UserView();
					userView.setUserId(Integer.parseInt(rs.getString("UserId")));
					userView.setFirstName(rs.getString("FirstName"));
					userView.setLastName(rs.getString("LastName"));
					userView.setUserId(rs.getInt("UserId"));
					userView.setMessage(rs.getTimestamp("LastLogin").toString());
					request.getSession().setAttribute("llogin",
							userView.getMessage());
					request.getSession().setAttribute("userId",
							userView.getUserId());
					
					//Update Timestamp
					//Date date = new Date();
					Timestamp t = new Timestamp(Calendar.getInstance().getTime().getTime());
					String queryupd = "Update Customer Set LastLogin='"+ t.toString() + "';";
					try {
						DatabaseHelper.executeQuery(queryupd);
					} catch (Exception e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// session.setAttribute("userId",userView.getUserId());

				} else {
					userView.setMessage("Invalid Password");
				}
			} else {
				userView.setMessage("Not Exists");
			}

			System.out.println("Password from db : " + origPasswd);
			System.out.println("Password entered : " + user.getPasswd());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return userView;
	}

	public void purchase(String userId) {
		ShoppingCartDao s = new ShoppingCartDao();
		System.out.println("purchase by " + userId);
		List<CartItem> listCart = s.getItemsInCart(userId);

		for (CartItem item : listCart) {
			System.out.println(item.getUserId());
			String query = "INSERT INTO `Shopify`.`Order` (`UserId`, `ProdId`, `ProdCategory`, `ProdDesc`, `QtyPurchased`,`Price`) VALUES ('"
					+ userId
					+ "', '"
					+ item.getProdId()
					+ "', '"
					+ item.getProdCategory()
					+ "', '"
					+ item.getProdDesc()
					+ "', '"
					+ item.getQtyBought()
					+ "', '"
					+ item.getPrice()
					+ "');";

			try {
				DatabaseHelper.executeQuery(query);
				List<String> attrList = new ArrayList<String>();
				//attrList.add(item.getProdCategory());
				//attrList.add(String.valueOf(item.getProdId()));
				attrList.add("ProdDescription");
				attrList.add("Price");
				attrList.add("Quantity");

				GetItemResult itemResult = AWSDAO.getItem(item.getProdId(),
						item.getProdCategory(), attrList);
				System.out.println("itemResult "+ itemResult);
				System.out.println("itemResult getItem "+ itemResult.getItem());
				Map<String, AttributeValue> i = itemResult.getItem();
				int qty = Integer.parseInt(i.get("Quantity").getN());
				
				int newQty = qty - item.getQtyBought();
				System.out.println(" New Qty "+newQty);
				System.out.println(i);
				Product p = new Product();
				p.setProdId(item.getProdId());
				p.setProdDescription(item.getProdDesc());
				p.setPrice(item.getPrice());
				p.setQtyAvailable(newQty);
				p.setProductCategory(item.getProdCategory());
				AWSDAO.addItem(p);
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	public OrderView order(String userId) {
		List<Order> orderList = null;
		String query = "Select * from `Shopify`.`Order` where UserId= " + userId+";";
		try {
			ResultSet result = DatabaseHelper.getResults(query);
			orderList = new ArrayList<Order>();
			
			while(result.next()){
				Order o = new Order();
				o.setProdId(result.getInt(2));
				o.setProdCategory(result.getString(3));
			    o.setProdDesc(result.getString(4));
			    o.setQtyPurchased(result.getInt(5));
			    o.setPrice(result.getDouble(6));
			    orderList.add(o);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new OrderView(orderList);
		
	}

}
