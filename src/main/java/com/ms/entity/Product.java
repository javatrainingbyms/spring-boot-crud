package com.ms.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity
public class Product {
	@Id
	private int id;
	private String name;
	private String brand;
	private int price;
}
