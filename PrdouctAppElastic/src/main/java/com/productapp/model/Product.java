package com.productapp.model;

public class Product {


	private String productName;

	    private String productId;

	    private double price;

	    private String brand;

	    private String category;

	    public Product(String productName, String productId, double price, String brand, String category) {

	        super();

	        this.productName = productName;

	        this.productId = productId;

	        this.price = price;

	        this.brand = brand;

	        this.category = category;

	    }

	    public Product() {

	        super();

	    }


	    public String getProductName() {

	        return productName;

	    }

	    public void setProductName(String productName) {

	        this.productName = productName;

	    }

	    public String getProductId() {

	        return productId;

	    }

	    public void setProductId(String productId) {

	        this.productId = productId;

	    }

	    public double getPrice() {

	        return price;

	    }

	    public void setPrice(double price) {

	        this.price = price;

	    }

	    public String getBrand() {

	        return brand;

	    }

	    public void setBrand(String brand) {

	        this.brand = brand;

	    }


	    public String getCategory() {

	        return category;

	    }

	    public void setCategory(String category) {

	        this.category = category;

	    }

	    @Override

	    public String toString() {

	        return "Product [productName=" + productName + ", productId=" + productId + ", price=" + price + ", brand="

	                + brand + ", category=" + category + "]";

	    }


}
