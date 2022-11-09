
package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.Product;

@Service
public class ProductServiceImpl implements ProductService {
	
	@Override
	public Product find(long productId) {
		Product product = new Product(productId, "Cep Telefonu", 1450);
		return product;
	}

	@Override
	public List<Product> findAll() {
		List<Product> productList = new ArrayList<>();
		productList.add(new  Product(301, "Cep Telefonu", 1450));
		productList.add(new  Product(302, "Dizüstü", 5000));
		productList.add(new  Product(303, "Masaüstü", 10000));
		return productList;
	}

	@Override
	public void createProduct(Product product) {
		product.setProductId(301);
		System.out.println("Ürün eklendi " + product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
	} 

	@Override
	public void updateProduct(Product product) {
		product.setProductId(301);
		System.out.println("Ürün güncellendi " + product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
	}

	@Override
	public void deleteProduct(long productId) {
		System.out.println("Ürün silindi " + productId);
	} 

}
