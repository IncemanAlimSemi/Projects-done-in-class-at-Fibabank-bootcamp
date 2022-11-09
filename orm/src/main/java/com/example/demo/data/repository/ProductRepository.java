package com.example.demo.data.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.demo.data.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Long> {
	
//	JPQL
	@Query("select p from Product p where p.salesPrice >= :minPrice ")
	List<Product> findAllBySalesPriceMin(@Param("minPrice") double minPrice);
}
