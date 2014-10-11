package edu.sjsu.cmpe282.domain;

public class Order {
	private int userId;
	private int prodId;
	private String prodCategory;
	private String prodDesc;
	private int qtyPurchased;
	private double price;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public String getProdCategory() {
		return prodCategory;
	}

	public void setProdCategory(String prodCategory) {
		this.prodCategory = prodCategory;
	}

	public String getProdDesc() {
		return prodDesc;
	}

	public void setProdDesc(String prodDesc) {
		this.prodDesc = prodDesc;
	}

	public int getQtyPurchased() {
		return qtyPurchased;
	}

	public void setQtyPurchased(int qtyPurchased) {
		this.qtyPurchased = qtyPurchased;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

}
