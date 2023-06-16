package com.jumin.springbootProject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CartDTO {

	private Long productId;
	private int quantity;
	
	public CartDTO(Long productId, int quantity) {
        this.productId = productId;
        this.quantity = quantity;
    }
}
