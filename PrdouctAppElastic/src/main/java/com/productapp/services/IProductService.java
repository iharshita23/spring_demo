package com.productapp.services;

import java.util.List;

import com.productapp.model.Product;

public interface IProductService {
	Product addProduct(Product product)throws Exception;
    Product getById(String productId)throws Exception;
    List<Product> getAll()throws Exception;
    List<Product> getByBrand(String brand)throws Exception;
    void updateProduct(String productId,Product product)throws Exception;
    void deleteProduct(String productId)throws Exception;
}
