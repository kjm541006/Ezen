package com.jumin.springbootProject.member.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jumin.springbootProject.member.repository.MemberRepository;
import com.jumin.springbootProject.member.repository.entity.MemberEntity;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	private final MemberRepository memberRepository;

	@Override
	public String join(String id, String name, String phoneNumber, String password) {
		MemberEntity member = MemberEntity.builder().id(id).name(name).phoneNumber(phoneNumber).password(password).build();
		memberRepository.save(member);
		
		return "success";
	}

	@Override
	public String login(String id, String password) {
		 MemberEntity member = MemberEntity.builder().id(id).password(password).build();
		 System.out.println(member);
		Optional<MemberEntity> byMemberId = memberRepository.findById(id);
		if(byMemberId.isPresent()) {
			// 조회 성공할경우
			//MemberEntity member = byMemberId.get();
			System.out.println("조회성공");
			System.out.println(member);
		}else {
			// 조회 실패할경우
			return null;
		}
		return "check";
	}

}
