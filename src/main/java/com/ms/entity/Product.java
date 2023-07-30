package com.ms.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
public class Product {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private String name;
	private String brand;
	private int price;
	@JsonIgnore
	@ManyToOne
	private Category category;
	
	
	
	public Product(String name, int price) {
		super();
		this.name = name;
		this.price = price;
	}
	
}
