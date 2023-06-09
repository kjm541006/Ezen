package com.jumin.springbootProject.member.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jumin.springbootProject.member.repository.entity.MemberEntity;
import java.util.List;


public interface MemberRepository extends JpaRepository<MemberEntity, Long> {

	// select * from member where id=?
	Optional<MemberEntity> findById(String id); 
}
