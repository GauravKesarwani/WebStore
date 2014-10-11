package edu.sjsu.cmpe282.domain;

import java.util.ArrayList;
import java.util.List;

public class ProductView {
	private List<Product> aaData = new ArrayList<Product>();

	public ProductView(){
		
	}
	public ProductView(List<Product> aaData) {
		super();
		this.setAaData(aaData);
	}
	public List<Product> getAaData() {
		return aaData;
	}
	public void setAaData(List<Product> aaData) {
		this.aaData = aaData;
	}
}