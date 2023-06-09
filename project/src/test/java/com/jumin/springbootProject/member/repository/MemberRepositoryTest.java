package com.jumin.springbootProject.member.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.jumin.springbootProject.member.repository.entity.MemberEntity;

@SpringBootTest
public class MemberRepositoryTest {

	
	@Autowired
	private MemberRepository memberRepository;
	
	@Test
	public void crudTest(){
		MemberEntity member = MemberEntity.builder()
				.id("아이디")
				.name("이름")
				.phoneNumber("010-0000-0000")
				.build();
	
	// createTest
	memberRepository.save(member);
	
	// getTest
	MemberEntity foundMember = memberRepository.findById(1L).get();
	
	}
}
