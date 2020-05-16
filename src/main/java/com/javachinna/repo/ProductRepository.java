package com.javachinna.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.javachinna.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
