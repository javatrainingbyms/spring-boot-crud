package com.ms.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ms.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	public List<Product> findByBrand(String brand);
	public List<Product> findByPriceBetween(int low, int high);
}
