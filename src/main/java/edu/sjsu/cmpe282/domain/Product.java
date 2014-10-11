package edu.sjsu.cmpe282.domain;

public class Product {

	private String productCategory;
	private int prodId;
	private double price;
	private String prodDescription;
	private int qtyAvailable;

	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Product(String productCategory, int prodId, double price,
			String prodDescription, int qtyAvailable) {
		super();
		this.productCategory = productCategory;
		this.prodId = prodId;
		this.price = price;
		this.prodDescription = prodDescription;
		this.qtyAvailable = qtyAvailable;
	}

	public String getProductCategory() {
		return productCategory;
	}

	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}

	public int getProdId() {
		return prodId;
	}

	public void setProdId(int prodId) {
		this.prodId = prodId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getProdDescription() {
		return prodDescription;
	}

	public void setProdDescription(String prodDescription) {
		this.prodDescription = prodDescription;
	}

	public int getQtyAvailable() {
		return qtyAvailable;
	}

	public void setQtyAvailable(int qtyAvailable) {
		this.qtyAvailable = qtyAvailable;
	}

}
