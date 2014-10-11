package edu.sjsu.cmpe282.dto;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.PropertiesCredentials;
import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.GetItemRequest;
import com.amazonaws.services.dynamodbv2.model.GetItemResult;

public class GettingStartedTryQuery {
	static AmazonDynamoDBClient client;
	 
    static SimpleDateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");

    public static void main(String[] args) throws Exception {
    	 createClient();
        try {
        
        // Get an item.
        getBook("101", "ProductCatalog");
        
        }  
        catch (AmazonServiceException ase) {
            System.err.println(ase.getMessage());
        }  
    }
    private static void createClient() throws Exception {
        AWSCredentials credentials = new PropertiesCredentials(
                GettingStartedLoadTables.class.getResourceAsStream("AwsCredentials.properties"));

        client = new AmazonDynamoDBClient(credentials);
    }
    
    private static void getBook(String id, String tableName) {
        Map<String, AttributeValue> key = new HashMap<String, AttributeValue>();
        key.put("ProductCategory", new AttributeValue().withS("Book"));
        key.put("ID", new AttributeValue().withN("101"));
        GetItemRequest getItemRequest = new GetItemRequest()
            .withTableName(tableName)
            .withKey(key)
            .withAttributesToGet(Arrays.asList("Id", "ISBN", "Title", "Authors"));
        
        GetItemResult result = client.getItem(getItemRequest);

        // Check the response.
        System.out.println("Printing item after retrieving it....");
        printItem(result.getItem());            
    }

   
  
    private static void printItem(Map<String, AttributeValue> attributeList) {
        for (Map.Entry<String, AttributeValue> item : attributeList.entrySet()) {
            String attributeName = item.getKey();
            AttributeValue value = item.getValue();
            System.out.println(attributeName + " "
                    + (value.getS() == null ? "" : "S=[" + value.getS() + "]")
                    + (value.getN() == null ? "" : "N=[" + value.getN() + "]")
                    + (value.getB() == null ? "" : "B=[" + value.getB() + "]")
                    + (value.getSS() == null ? "" : "SS=[" + value.getSS() + "]")
                    + (value.getNS() == null ? "" : "NS=[" + value.getNS() + "]")
                    + (value.getBS() == null ? "" : "BS=[" + value.getBS() + "] \n"));
        }
    }
}