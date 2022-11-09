package com.example.demo.presentation.mvc;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.data.entity.Product;
import com.example.demo.data.repository.ProductRepository;

@Controller
@RequestMapping("/invertory")
public class ProductController {
	
//	@Autowired
	private ProductRepository productRepository;
	public ProductController(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	@GetMapping("/product/insert")
	@ResponseBody
	public String insertProduct() {
		Product product = new Product();
		product.setProductName("Cep Telefonu");
		product.setSalesPrice(3250);
		productRepository.save(product);
		return "Sokuldu: " + product.getProductId();
	}
	
	@GetMapping("/product/find")
	@ResponseBody
	public String findProduct() {
		long productId = 1;
		Optional<Product> optional = productRepository.findById(productId);
		if (optional.isPresent()) {
			Product product = optional.get();
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
			return "Ürün bulundu: " + product.getProductName();
		}
		
		return "Ürün bulunamadı";
	}
	
	@GetMapping("/product/list")
	@ResponseBody
	public String listProduct() {
		Iterable<Product> products = productRepository.findAll();
		int count = 0;
		for (Product product : products) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
			count++;
		}
		
		return "Ürün sayısı: " + count;
	}
	
	@GetMapping("/product/expensives")
	@ResponseBody
	public String listExpensiveProduct() {
		double minPrice = 2000;
		Iterable<Product> products = productRepository.findAllBySalesPriceMin(minPrice);
		int count = 0;
		for (Product product : products) {
			System.out.println(product.getProductId() + " " + product.getProductName() + " " + product.getSalesPrice());
			count++;
		}
		
		return "Ürün sayısı: " + count;
	}
	
	@GetMapping("/product/delete")
	@ResponseBody
	public String deleteProduct() {
		long productId = 3;
		if(!productRepository.existsById(productId)) {
			return "Bulunamadı " + productId;
		}
		productRepository.deleteById(productId);
		return "Silindi. ";
	}
}
