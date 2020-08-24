package br.com.donadon.model;

public class Seller {
	
	private long cpf;
	private String name;
	private double salary;
	
	public Seller(long cpf, String name, double salary) {
		super();
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}
	public long getCpf() {
		return cpf;
	}
	public void setCpf(long cpf) {
		this.cpf = cpf;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	
	
}
