package br.com.donadon.model;

import java.util.List;

public class Sale {
	
	private int id;
	private List<SaleItem> items;
	private String salesmanName;
	
	public Sale(int id, List<SaleItem> items, String salesmanName) {
		super();
		this.id = id;
		this.items = items;
		this.salesmanName = salesmanName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public List<SaleItem> getItems() {
		return items;
	}

	public void setItems(List<SaleItem> items) {
		this.items = items;
	}

	public String getSalesmanName() {
		return salesmanName;
	}

	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	
	public double getSaleValue() {
		return items.stream().mapToDouble(v -> v.getTotalItemsValue()).sum();
	}
	
}
