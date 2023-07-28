package com.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.ms.dto.PriceList;
import com.ms.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {
	public List<Product> findByBrand(String brand);
	public List<Product> findByPriceBetween(int low, int high);
	
	@Query("select p from Product p where p.price <= 10000")
	public List<Product> findLow(); //below 10000

	//@Query("select new com.ms.dto.PriceList(p.name, p.brand, p.price) from Product p")
	//@Query("select new com.ms.entity.Product(pp.name, p.price) from Product p")
	@Query("select p from Product p")
	public List<Product> getPriceList();
	
	

}
