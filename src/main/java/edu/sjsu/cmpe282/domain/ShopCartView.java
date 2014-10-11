package edu.sjsu.cmpe282.domain;

import java.util.ArrayList;
import java.util.List;

public class ShopCartView {
	private List<CartItem> aaData = new ArrayList<CartItem>();

	public ShopCartView(List<CartItem> aaData) {
		super();
		this.setAaData(aaData);
	}

	public List<CartItem> getAaData() {
		return aaData;
	}

	public void setAaData(List<CartItem> aaData) {
		this.aaData = aaData;
	}
}
