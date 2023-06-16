package com.jumin.springbootProject.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jumin.springbootProject.dto.ProductDTO;
import com.jumin.springbootProject.entity.ProductEntity;
import com.jumin.springbootProject.repository.ProductRepository;

import lombok.RequiredArgsConstructor;

@Service
public class ProductService {

	private final ProductRepository productRepository;
	
	public ProductService(ProductRepository productRepository) {
		this.productRepository = productRepository;
	}
	
	public String save(ProductDTO productDTO) {
		// dto -> entity
		Optional<ProductEntity> byName = productRepository.findByName(productDTO.getName());
		if(byName.isPresent()) {
			return "fail";
		}else {
			ProductEntity productEntity = new ProductEntity();
            productEntity.setName(productDTO.getName());
            productEntity.setQuantity(productDTO.getQuantity());
            productRepository.save(productEntity);
            return "success";
		}
	}

    public List<ProductEntity> getAllProducts() {
        return productRepository.findAll();
    }
    
    public ProductEntity getProductById(Long productId) {
        return productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found with productId: " + productId));
    }

    public void saveProduct(ProductEntity product) {
        productRepository.save(product);
    }
	
}
