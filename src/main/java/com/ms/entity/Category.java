package com.ms.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Category {
	@Id
	private int id;
	private String categoryCode;
	private String categoryName;
	@JsonIgnore
	@OneToMany(mappedBy = "category")
	private List<Product> products;
}
