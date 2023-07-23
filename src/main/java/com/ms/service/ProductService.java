package com.ms.service;

import java.util.Optional;

import org.springframework.dao.OptimisticLockingFailureException;

import com.ms.entity.Product;

public interface ProductService {
	Product save(Product product);
	Iterable<Product> saveAll(Iterable<Product> entities);
	Optional<Product> findById(Integer id);
	boolean existsById(Integer id);
	Iterable<Product> findAll();
	Iterable<Product> findAllById(Iterable<Integer> ids);
	long count();
	void deleteById(Integer id);
	void delete(Product entity);
	void deleteAllById(Iterable<Integer> ids);
	void deleteAll(Iterable<Product> entities);
	void deleteAll();
}
