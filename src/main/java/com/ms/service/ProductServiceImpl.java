package com.ms.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

import com.ms.entity.Product;
import com.ms.repo.ProductRepository;

@Service
public class ProductServiceImpl implements ProductService{
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Product save(Product product) {
		return productRepository.save(product);
	}

	@Override
	public Iterable<Product> saveAll(Iterable<Product> products) {
		return productRepository.saveAll(products);
	}

	@Override
	public Optional<Product> findById(Integer id) {
		return productRepository.findById(id);
	}

	@Override
	public boolean existsById(Integer id) {
		return productRepository.existsById(id);
	}

	@Override
	public Iterable<Product> findAll() {
		return productRepository.findAll();
	}

	@Override
	public Iterable<Product> findAllById(Iterable<Integer> ids) {
		return productRepository.findAllById(ids);
	}

	@Override
	public long count() {
		return productRepository.count();
	}

	@Override
	public void deleteById(Integer id) {
		productRepository.deleteById(id);
	}

	@Override
	public void delete(Product product) {
		productRepository.delete(product);
		
	}

	@Override
	public void deleteAllById(Iterable<Integer> ids) {
		productRepository.deleteAllById(ids);
		
	}

	@Override
	public void deleteAll(Iterable<Product> products) {
		productRepository.deleteAll(products);
	}

	@Override
	public void deleteAll() {
		productRepository.deleteAll();
	}

	@Override
	public List<Product> findProductsByBrand(String brand) {
		return productRepository.findByBrand(brand);
	}

	@Override
	public List<Product> findByPriceBetween(int low, int high) {
		return productRepository.findByPriceBetween(low,high);
	}

	@Override
	public Iterable<Product> findAll(String field) {
		Sort sort=Sort.by(Direction.ASC, field);
		return productRepository.findAll(sort);
	}

}
