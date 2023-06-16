package com.jumin.springbootProject.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumin.springbootProject.entity.ProductEntity;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

	Optional<ProductEntity> findByName(String name);
	List<ProductEntity> findAll();
}