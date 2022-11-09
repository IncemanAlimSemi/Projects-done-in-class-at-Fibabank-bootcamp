package com.example.demo.business.service;

import java.util.List;

import com.example.demo.business.dto.ProductDto;

public interface ProductService {

	long create(ProductDto productDto);
	
	void update(ProductDto productDto);
	
	ProductDto find(long productId);
	
	List<ProductDto> findAll();
	
	void delete(long productId);
}
