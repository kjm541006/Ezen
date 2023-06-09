package com.jumin.springbootProject.service;

import java.util.Optional;

import org.springframework.stereotype.Service;

import com.jumin.springbootProject.dto.MemberDTO;
import com.jumin.springbootProject.entity.MemberEntity;
import com.jumin.springbootProject.repository.MemberRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;

	public void save(MemberDTO memberDTO) {
		// dto -> entity
		MemberEntity memberEntity = MemberEntity.toMemberEntity(memberDTO);
		// repository의 save 메서드호출 (entity객체 넘김)
		memberRepository.save(memberEntity);
		
	}

	public String login(MemberDTO memberDTO) {
		Optional<MemberEntity> byEmail = memberRepository.findByEmail(memberDTO.getEmail());
		if(byEmail.isPresent()) {
			// 조회결과가 있을경우
			MemberEntity memberEntity = byEmail.get();
			if(memberEntity.getPassword().equals(memberDTO.getPassword())) {
				// 비밀번호 일치
				// entity -> dto
				MemberDTO dto = MemberDTO.toMemberDTO(memberEntity);
				System.out.println(dto);
				return "success";
				
			} else {
				// 비밀번호 불일치
				System.out.println("비밀번호 불일치");
				return "password error";
			}
		}else {
			// 조회결과가 없을경우
			System.out.println("이메일 조회 실패");
			return "not found";
		}
	}

}
