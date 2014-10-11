package edu.sjsu.cmpe282.dto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

import edu.sjsu.cmpe282.domain.Product;
import edu.sjsu.cmpe282.domain.ProductView;

public class ProductDao {
	Connection conn = null;
	static AmazonDynamoDBClient client;
	List<Product> prodList = new ArrayList<Product>();
	HttpSession session = null;
	ServletContext s = null;

	// Constructure with JDBC connection
	public ProductDao() {
	}

	/*
	 * // A private method to calculate the count of records in any table
	 * private int getRowCount(ResultSet resultSet) { if (resultSet == null) {
	 * return 0; } try { resultSet.last(); return resultSet.getRow(); } catch
	 * (SQLException exp) { exp.printStackTrace(); } finally { try {
	 * resultSet.beforeFirst(); } catch (SQLException exp) {
	 * exp.printStackTrace(); } } return 0; }
	 */

	public ProductView getAllProds(String cat) {

		QueryResult results = AWSDAO.getProductsOfCatalog(cat);
		List<Product> prodList = constructResult(results);
		// System.out.println(b1);
		return new ProductView(prodList);
		// s = request.getServletContext();
		// s.setAttribute("prodView", prodV);
		// request.getSer
		// session.setAttribute("prodView", prodV);
		// return prodV;
		
	}

	/*
	 * public ProductView getProductView(){ return (ProductView)
	 * s.getAttribute("prodView"); }
	 */

	public List<Product> constructResult(QueryResult r) {
		List<Product> prodList = new ArrayList<Product>();
		for (Map<String, AttributeValue> item : r.getItems()) {
			Product p = new Product();
			p.setProdId(Integer.parseInt((item.get("ProdId")).getN()));
			p.setProductCategory(item.get("ProdCategory").getS());
			p.setProdDescription(item.get("ProdDescription").getS());
			p.setPrice(Double.parseDouble(item.get("Price").getN()));
			p.setQtyAvailable(Integer.parseInt(item.get("Quantity").getN()));
			prodList.add(p);
		}

		return prodList;
	}

	public void addProduct(Product prod) {
		String query = "INSERT INTO `Shopify`.`Product_Id_AutoIncrement` (`ProductDummy`) VALUES ('dummy');";

		try {
			DatabaseHelper.executeQuery(query);

			String lastInsertId = "Select Count(*) from Product_Id_AutoIncrement";
			ResultSet r = DatabaseHelper.getResults(lastInsertId);
			int lastId = 0;
			while (r.next()) {
				lastId = r.getInt(1);
			}
			System.out.println("Last Inserted Item " + lastId);
			prod.setProdId(lastId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		AWSDAO.addItem(prod);
	}
	
	}
