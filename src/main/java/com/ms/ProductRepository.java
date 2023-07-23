package com.ms;

import org.springframework.data.repository.CrudRepository;

import com.ms.entity.Product;

public interface ProductRepository extends CrudRepository<Product, Integer> {

}
