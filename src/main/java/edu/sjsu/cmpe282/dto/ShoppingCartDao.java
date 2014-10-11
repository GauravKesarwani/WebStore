package edu.sjsu.cmpe282.dto;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.QueryResult;

import edu.sjsu.cmpe282.domain.CartItem;

public class ShoppingCartDao {

	public void addToCart(CartItem cartItem) {
		// TODO Auto-generated method stub
		AWSDAO.addToCart(cartItem);
	}

	public List<CartItem> getItemsInCart(String userId) {
		return constructResult(AWSDAO.getItemsInCart(userId));

	}

	public List<CartItem> constructResult(QueryResult r) {
		List<CartItem> itemsList = new ArrayList<CartItem>();
		for (Map<String, AttributeValue> item : r.getItems()) {
			CartItem c = new CartItem();
			c.setProdId(Integer.parseInt((item.get("ProdId")).getN()));
			c.setProdCategory(item.get("ProdCategory").getS());
			c.setProdDesc(item.get("ProdDescription").getS());
			c.setPrice((Double.parseDouble(item.get("Price").getN())) * (Integer.parseInt(item.get("QtyBought").getN())));
			c.setQtyBought(Integer.parseInt(item.get("QtyBought").getN()));
			itemsList.add(c);
		}

		return itemsList;
	}

	public void updProduct(CartItem c) {
		//String query = "INSERT INTO `AWSOnline`.`Product_Id_AutoIncrement` (`ProductDummy`) VALUES ('dummy');";

		System.out.println("Inside update product Dao");
		AWSDAO.addToCart(c);
	}


}
