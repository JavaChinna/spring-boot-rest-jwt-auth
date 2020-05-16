package com.javachinna.service;

import java.util.List;
import java.util.Optional;

import com.javachinna.model.Product;

public interface ProductService {
	Product save(Product product);

	void deleteById(Long id);

	Optional<Product> findById(Long id);

	List<Product> findAll();
}
