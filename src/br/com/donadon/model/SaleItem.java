package br.com.donadon.model;

import java.util.ArrayList;
import java.util.List;

public class SaleItem {

	private int itemId;
	private long quantityItem;
	private double priceItem;
	
	public static List<SaleItem> getItems(String hashItem) {
		String[] items = hashItem.substring(1, hashItem.length()-1).split(",");
		
		
		List<SaleItem> list = new ArrayList<SaleItem>(); 
		
		for ( String item : items ) {
			String[] data = item.split("-");
			
			SaleItem si = new SaleItem(
					Integer.parseInt( data[0].toString() ), 
					Long.parseLong( data[1].toString() ), 
					Double.parseDouble( data[2].toString() ));
			
			list.add(si);
		}
		
		return list;
	}
	
	public SaleItem(int itemId, long quantityItem, double priceItem) {
		super();
		this.itemId = itemId;
		this.quantityItem = quantityItem;
		this.priceItem = priceItem;
	}
	
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public long getQuantityItem() {
		return quantityItem;
	}
	public void setQuantityItem(long quantityItem) {
		this.quantityItem = quantityItem;
	}
	public double getPriceItem() {
		return priceItem;
	}
	public void setPriceItem(double priceItem) {
		this.priceItem = priceItem;
	}
	
	public double getTotalItemsValue() {
		return this.priceItem * this.quantityItem;
	}
	
	
	
}
