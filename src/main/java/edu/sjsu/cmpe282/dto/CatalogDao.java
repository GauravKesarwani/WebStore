package edu.sjsu.cmpe282.dto;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDBClient;
import com.amazonaws.services.dynamodbv2.model.AttributeValue;
import com.amazonaws.services.dynamodbv2.model.ScanResult;

import edu.sjsu.cmpe282.domain.Catalog;
import edu.sjsu.cmpe282.domain.CatalogView;

public class CatalogDao {
	Connection conn = null;
	static AmazonDynamoDBClient client;
	List<Catalog> catList = new ArrayList<Catalog>();

	// Constructure with JDBC connection
	public CatalogDao() {
	}

	/*
	 * // A private method to calculate the count of records in any table
	 * private int getRowCount(ResultSet resultSet) { if (resultSet == null) {
	 * return 0; } try { resultSet.last(); return resultSet.getRow(); } catch
	 * (SQLException exp) { exp.printStackTrace(); } finally { try {
	 * resultSet.beforeFirst(); } catch (SQLException exp) {
	 * exp.printStackTrace(); } } return 0; }
	 */

	public CatalogView getAllCatalogs() {
		System.out.println("Inside Get All Catalogs Dao");
		ScanResult results = AWSDAO.getItemsByQuery("Catalog");
		List<Catalog> catList = constructResult(results);
		// System.out.println(b1);
		return new CatalogView(catList);

	}

	public List<Catalog> constructResult(ScanResult r) {
		List<Catalog> catList = new ArrayList<Catalog>();
		for (Map<String, AttributeValue> item : r.getItems()) {
			Catalog c = new Catalog();
			c.setCatalogName(item.get("CatalogName").getS());
			c.setCatalogDesc(item.get("CatalogDesc").getS());
			catList.add(c);
		}

		return catList;
	}

	public void addCatalog(Catalog cat) {
		AWSDAO.addCatalog(cat);
	}
}
