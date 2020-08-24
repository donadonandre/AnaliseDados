package br.com.donadon.process;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import br.com.donadon.model.Customer;
import br.com.donadon.model.Sale;
import br.com.donadon.model.Seller;

public class DataAnalisis {
	
	private List<Customer> listCustomers;
	private List<Seller> listSellers;
	private List<Sale> listSales;
	
	public DataAnalisis() {
		listCustomers = new ArrayList<Customer>();
		listSellers = new ArrayList<Seller>();
		listSales = new ArrayList<Sale>();
	}
	
	public void add(Customer obj) {
		this.listCustomers.add(obj);
	}
	
	public void add(Seller obj) {
		this.listSellers.add(obj);
	}
	
	public void add(Sale obj) {
		this.listSales.add(obj);
	}
	
	public int getAllCustomers() {
		return this.listCustomers.size();
	}

	public int getAllSellers() {
		return this.listSellers.size();
	}
	
	public double getHighestSale() {
		return this.listSales.stream().mapToDouble(v -> v.getSaleValue()).max().getAsDouble();
	}
	
	public String getWorstSeller() {
		Comparator<Sale> comp = Comparator.comparing( Sale::getSaleValue );
		
		return ( listSales.stream().min(comp).get() ).getSalesmanName();
	}
	
}
