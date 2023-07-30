package com.ms.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductCategory {
	//@JsonProperty("prod_name")
	private String pname;
	//@JsonProperty("prod_price")
	private int cost;
	//@JsonProperty("cat_name")
	private String cName;
	private String ctName;
}
