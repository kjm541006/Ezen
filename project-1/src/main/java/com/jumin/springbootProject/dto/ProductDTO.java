package com.jumin.springbootProject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductDTO {

	private Long id;
	private String name;
	private int price;
	private int quantity;
	private boolean isNew;
	private int discountRate;
}