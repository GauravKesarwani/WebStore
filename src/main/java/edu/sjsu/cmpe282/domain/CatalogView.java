package edu.sjsu.cmpe282.domain;

import java.util.ArrayList;
import java.util.List;

public class CatalogView {

	private List<Catalog> aaData = new ArrayList<Catalog>();

	public CatalogView() {

	}

	public CatalogView(List<Catalog> aaData) {
		super();
		this.setAaData(aaData);
	}

	public List<Catalog> getAaData() {
		return aaData;
	}

	public void setAaData(List<Catalog> aaData) {
		this.aaData = aaData;
	}

}
