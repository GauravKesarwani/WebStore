package edu.sjsu.cmpe282.domain;

import java.util.ArrayList;
import java.util.List;

public class OrderView {

	private List<Order> aaData = new ArrayList<Order>();

	public OrderView() {

	}


	public OrderView(List<Order> aaData) {
		super();
		this.setAaData(aaData);
	}

	public List<Order> getAaData() {
		return aaData;
	}

	public void setAaData(List<Order> aaData) {
		this.aaData = aaData;
	}
}