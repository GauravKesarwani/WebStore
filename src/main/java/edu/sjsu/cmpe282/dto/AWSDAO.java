package edu.sjsu.cmpe282.dto;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ComparisonOperator;
import com.amazonaws.services.dynamodbv2.model.Condition;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;
import com.amazonaws.services.dynamodbv2.model.PutItemRequest;
import com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import edu.sjsu.cmpe282.domain.CartItem;
import edu.sjsu.cmpe282.domain.Catalog;
import edu.sjsu.cmpe282.domain.Product;

public class AWSDAO {

	static AmazonDynamoDBClient client;
	static String productCatalogTableName = "ProductCatalog";

	public static void main(String[] args) throws Exception {
		// getClient();
		try {
			// addItem(new Product("Book",104,123.00,"Hamlet by Shakepeare",
			// 4));
			// getItemsByQuery("ProductCatalog");

			// List<String> attrList = new ArrayList<String>();
			// attrList.add("ID");
			// attrList.add("ISBN");
			// attrList.add("Title");
			// attrList.add("Authors");
			// Get an item.
			// getItem(101,"Book", attrList);
		} catch (AmazonServiceException ase) {
			ase.printStackTrace();
		}
	}

	public static AmazonDynamoDBClient getClient() throws Exception {

		if (client == null) {
			AWSCredentials credentials = new PropertiesCredentials(
					AWSDAO.class
							.getResourceAsStream("AwsCredentials.properties"));

			client = new AmazonDynamoDBClient(credentials);
		} else {
			return client;
		}
		return client;
	}

	public static ScanResult getItemsByQuery(String tableName) {
		// category eg: Book, Bike, truck etc
		System.out.println("Inside get items by Query");
		ScanResult result = null;
		try {
			getClient();

			ScanRequest scanRequest = new ScanRequest()
					.withTableName(tableName);

			result = client.scan(scanRequest);
			// for (Map<String, AttributeValue> item : result.getItems()){
			// System.out.println(item.get("CatalogName").getS());
			// System.out.println(item.get("CatalogDesc").getS());
			// System.out.println(item.get("ProdDescription").getS());
			// System.out.println(item.get("Price").getN());
			// System.out.println(Integer.parseInt(item.get("QtyAvailable").getN()));
			// }
			/*
			 * Condition hashKeyCondition = new Condition()
			 * .withComparisonOperator(ComparisonOperator.EQ)
			 * .withAttributeValueList( new AttributeValue().withS(category));
			 * 
			 * Map<String, Condition> keyConditions = new HashMap<String,
			 * Condition>(); keyConditions.put("ProductCategory",
			 * hashKeyCondition);
			 * 
			 * QueryRequest queryRequest = new QueryRequest().withTableName(
			 * "ProductCatalog").withKeyConditions(keyConditions);
			 * 
			 * result = client.query(queryRequest); for (Map<String,
			 * AttributeValue> item : result.getItems()) { printItem(item); }
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	/*
	 * This method will fetch the products for an individual catalog. The
	 * catalog name is passed as parameter to this method and it fetches all the
	 * products for the catalog and returns the result.
	 */
	public static QueryResult getProductsOfCatalog(String catalogName) {
		try {
			client = getClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Condition hashKeyCondition = new Condition().withComparisonOperator(
				ComparisonOperator.EQ.toString()).withAttributeValueList(
				new AttributeValue().withS(catalogName));

		Map<String, Condition> keyConditions = new HashMap<String, Condition>();
		keyConditions.put("ProdCategory", hashKeyCondition);

		QueryRequest queryRequest = new QueryRequest()
				.withTableName("ProductCatalog")
				.withKeyConditions(keyConditions)
				.withAttributesToGet(
						Arrays.asList("ProdCategory", "ProdId",
								"ProdDescription", "Price", "Quantity"));

		QueryResult result = client.query(queryRequest);
		for (Map<String, AttributeValue> item : result.getItems()) {

			System.out.println(item.get("ProdCategory").getS());
			System.out.println(item.get("ProdId").getN());
			System.out.println(item.get("ProdDescription").getS());
			System.out.println(item.get("Price").getN());
			System.out.println(Integer.parseInt(item.get("Quantity").getN()));
		}
		return result;
	}

	public static GetItemResult getItem(Integer id, String category,
			List<String> attrList) {
		GetItemResult result = null;
		try {
			getClient();

			Map<String, AttributeValue> key = new HashMap<String, AttributeValue>();
			key.put("ProdCategory", new AttributeValue().withS(category));
			key.put("ProdId", new AttributeValue().withN(id.toString()));
			GetItemRequest getItemRequest = new GetItemRequest()
					.withTableName("ProductCatalog").withKey(key)
					.withAttributesToGet(attrList);
			System.out.println(id.toString());
			System.out.println(category);
			result = client.getItem(getItemRequest);

			// Check the response.
			/*
			 * System.out.println("Printing item after retrieving it....");
			 * printItem(result.getItem());
			 */
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

	public static void addItem(Product prod) {
		try {
			getClient();
			String tableName = "ProductCatalog";
			Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
			item.put("ProdCategory",
					new AttributeValue().withS(prod.getProductCategory()));
			item.put("ProdId", new AttributeValue().withN(String.valueOf(prod
					.getProdId())));
			item.put("Price",
					new AttributeValue().withN(String.valueOf(prod.getPrice())));
			item.put("ProdDescription",
					new AttributeValue().withS(prod.getProdDescription()));
			item.put("Quantity", new AttributeValue().withN(String
					.valueOf(prod.getQtyAvailable())));
			PutItemRequest putItemRequest = new PutItemRequest().withTableName(
					tableName).withItem(item);
			client.putItem(putItemRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * This method will take input parameter as Catalog Name and create a new
	 * catalog row in the Dynmo db table named "Catalog"
	 */
	public static void addCatalog(Catalog cat) {
		try {
			getClient();
			System.out.println("Inside Add Catalog");
			String tableName = "Catalog";
			Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
			item.put("CatalogName",
					new AttributeValue().withS(cat.getCatalogName()));
			item.put("CatalogDesc",
					new AttributeValue().withS(cat.getCatalogDesc()));
			PutItemRequest putItemRequest = new PutItemRequest().withTableName(
					tableName).withItem(item);
			client.putItem(putItemRequest);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void addToCart(CartItem cartItem) {
		try {
			getClient();
			String tableName = "ShoppingCart";
			Map<String, AttributeValue> item = new HashMap<String, AttributeValue>();
			item.put("UserId", new AttributeValue().withN(String
					.valueOf(cartItem.getUserId())));
			item.put("ProdId", new AttributeValue().withN(String
					.valueOf(cartItem.getProdId())));
			item.put("Price", new AttributeValue().withN(String
					.valueOf(cartItem.getPrice())));
			item.put("ProdCategory",
					new AttributeValue().withS(cartItem.getProdCategory()));
			item.put("ProdDescription",
					new AttributeValue().withS(cartItem.getProdDesc()));
			item.put("QtyBought", new AttributeValue().withN(String
					.valueOf(cartItem.getQtyBought())));
			PutItemRequest putItemRequest = new PutItemRequest().withTableName(
					tableName).withItem(item);
			client.putItem(putItemRequest);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/*
	 * private static void printItem(Map<String, AttributeValue> attributeList)
	 * { for (Map.Entry<String, AttributeValue> item : attributeList.entrySet())
	 * { String attributeName = item.getKey(); AttributeValue value =
	 * item.getValue(); System.out.println(attributeName + " " + (value.getS()
	 * == null ? "" : ":" + value.getS()) + (value.getN() == null ? "" : ":" +
	 * value.getN()) + (value.getB() == null ? "" : ":" + value.getB()) +
	 * (value.getSS() == null ? "" : ":" + value.getSS()
	 * 
	 * + (value.getNS() == null ? "" : ":" + value.getNS()) + (value.getBS() ==
	 * null ? "" : ":" + value.getBS() + "\n"))); } }
	 */

	public static QueryResult getItemsInCart(String userId) {
		try {
			client = getClient();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Condition hashKeyCondition = new Condition().withComparisonOperator(
				ComparisonOperator.EQ.toString()).withAttributeValueList(
				new AttributeValue().withN(userId));

		Map<String, Condition> keyConditions = new HashMap<String, Condition>();
		keyConditions.put("UserId", hashKeyCondition);

		QueryRequest queryRequest = new QueryRequest()
				.withTableName("ShoppingCart")
				.withKeyConditions(keyConditions)
				.withAttributesToGet(
						Arrays.asList("ProdCategory", "ProdId",
								"ProdDescription", "Price", "QtyBought"));

		QueryResult result = client.query(queryRequest);
		for (Map<String, AttributeValue> item : result.getItems()) {

			System.out.println(item.get("ProdCategory").getS());
			System.out.println(item.get("ProdId").getN());
			System.out.println(item.get("ProdDescription").getS());
			System.out.println(item.get("Price").getN());
			System.out.println(item.get("QtyBought").getN());
		}
		return result;

		
	}

}
