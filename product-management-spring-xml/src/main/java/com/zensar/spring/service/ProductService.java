package com.zensar.spring.service;

import java.util.List;

import com.zensar.spring.beans.Product;

public interface ProductService {

	public int insertProduct(Product product);

	public List<Product> getAllProducts();

	public void updateProduct(int id,String productName,int productCost);

	public void deleteProduct(int id);
}

