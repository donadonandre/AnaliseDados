package br.com.donadon.model;

public class Customer {

	private long cnpj;
	private String nameBusiness;
	private String area;
	
	public Customer(long cnpj, String nameBusiness, String area) {
		super();
		this.cnpj = cnpj;
		this.nameBusiness = nameBusiness;
		this.area = area;
	}

	public long getCnpj() {
		return cnpj;
	}

	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}

	public String getNameBusiness() {
		return nameBusiness;
	}

	public void setNameBusiness(String nameBusiness) {
		this.nameBusiness = nameBusiness;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}
	
	
	
}
