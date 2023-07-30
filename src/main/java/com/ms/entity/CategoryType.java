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
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoryType {
	@Id
	private int id;
	private String ctcode;
	private String ctname;
	@JsonIgnore
	@OneToMany(mappedBy="categoryType")
	private List<Category> categories;
}
