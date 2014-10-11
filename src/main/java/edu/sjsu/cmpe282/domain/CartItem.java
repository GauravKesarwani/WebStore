package edu.sjsu.cmpe282.domain;

public class CartItem {
	private String userId;
	private int prodId;
	private String prodCategory;
	private String prodDesc;
	private double price;
	private int qtyBought;

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
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

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getQtyBought() {
		return qtyBought;
	}

	public void setQtyBought(int qtyBought) {
		this.qtyBought = qtyBought;
	}
}
