package com.productapp.dao;

import java.util.List;

import com.productapp.model.Product;

public interface IProductDao {
	String addProduct(Product product) throws Exception;
    Product findById(String productId) throws Exception;
    List<Product> findAll() throws Exception;
    List<Product> findByBrand(String brand) throws Exception;
    void updateProduct(String productId,Product price) throws Exception;
    void deleteProduct(String productId) throws Exception;
}
