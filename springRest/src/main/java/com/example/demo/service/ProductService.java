package com.example.demo.service;

import java.util.List;


import com.example.demo.Product;

public interface ProductService {

	Product find(long productId);
	List<Product> findAll();
	void createProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(long productId);
	
}