package com.ms.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.dto.ProductCategory;
import com.ms.entity.Product;
import com.ms.repo.ProductRepository;
import com.ms.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@Autowired
	private ProductRepository repo;
	
	@GetMapping("/sort/{field}")
	public Iterable<Product> getSortedProducts(@PathVariable("field")  String field){
		return productService.findAll(field);
	}
	
	@GetMapping("/productcategory")
	public List<ProductCategory> getProductWithCategory(){
		return repo.getProductCategory();
	}
	@GetMapping("/pricelist")
	public List<Product> getPriceList(){
		return repo.getPriceList();
	}
	@GetMapping("/lowprice/{amount}/{brand}")
	public List<Product> findLowPriceProducts(@PathVariable("amount") int amount, @PathVariable("brand") String brand){
		return repo.findLow(amount,brand);
		//return repo.findByPriceLessThan(amount);
	}
	@GetMapping("/price/{low}/{high}")
	public List<Product> findProductsByPriceRange(@PathVariable("low") int low, @PathVariable("high") int high){
		return productService.findByPriceBetween(low,high);
	}
	@GetMapping("/brand/{brand}")
	public List<Product> findProductsByBrand(@PathVariable("brand") String brand){
		return productService.findProductsByBrand(brand);
	}
	@GetMapping(value="/count")
	public Long countProducts() {
		return productService.count();
	}
	@PutMapping (consumes = "application/json", produces="application/json")
	public Product updateProduct(@RequestBody Product product) {
		return productService.save(product);
	}
	@PostMapping (consumes = "application/json", produces="application/json")
	public Product saveProduct(@RequestBody Product product) {
		return productService.save(product);
	}
	@GetMapping
	public Iterable<Product> getAllProducts(){
		return productService.findAll();
	}
	@GetMapping(value="/{id}")
	public Product getSingleProduct(@PathVariable("id") int id){
		Optional<Product> optional=productService.findById(id);
		Product product=null;
		if(optional.isPresent()) {
			product=optional.get();//get method will extract the product object from optional
		}else {
			product=new Product();
		}
		product.getCategory();
		return product;
	}
}
