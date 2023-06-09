package com.jumin.springbootProject.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumin.springbootProject.entity.MemberEntity;

public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	Optional<MemberEntity> findByEmail(String email);
}
