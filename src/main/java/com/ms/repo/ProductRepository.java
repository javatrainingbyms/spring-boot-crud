package com.ms.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.ms.dto.ProductCategory;
import com.ms.entity.Product;

public interface ProductRepository extends PagingAndSortingRepository<Product,Integer>{//CrudRepository<Product, Integer> {
	public List<Product> findByBrand(String brand);
	public List<Product> findByPriceBetween(int low, int high);
	
	@Query("select p from Product p where p.price <= ?1 and p.brand=?2")
	public List<Product> findLow(int amount, String brand);    
	
	//public List<Product> findByPriceLessThan(int amount);

	//@Query("select new com.ms.dto.PriceList(p.name, p.brand, p.price) from Product p")
	//@Query("select new com.ms.entity.Product(pp.name, p.price) from Product p")
	@Query("select p from Product p")
	public List<Product> getPriceList();
	
	@Query("SELECT new com.ms.dto.ProductCategory(p.name,p.price,c.categoryName,ct.ctname) FROM Product p JOIN p.category c JOIN  c.categoryType ct")
	public List<ProductCategory> getProductCategory();
	
	

}
