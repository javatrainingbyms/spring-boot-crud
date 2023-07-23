package com.ms.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.entity.Product;
import com.ms.service.ProductService;

@RestController
@RequestMapping("products")
public class ProductController {
	@Autowired
	private ProductService productService;
	
	@GetMapping
	public Iterable<Product> getAllProducts(){
		return productService.findAll();
	}
	@GetMapping(value="/{id}")
	public Product getSingleProduct(@PathVariable("id") int id){
		Optional<Product> optional=productService.findById(id);
		return optional.get();
	}
}
