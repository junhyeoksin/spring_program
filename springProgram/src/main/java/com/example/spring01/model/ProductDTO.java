package com.example.spring01.model;

public class ProductDTO {
	private String name;
	private double price;
	
	public ProductDTO() {}

	public String getName() {
		return name;
	}

	
	
	
	
	public ProductDTO(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return "ProductDTO [name=" + name + ", price=" + price + "]";
	}
	
	
}
