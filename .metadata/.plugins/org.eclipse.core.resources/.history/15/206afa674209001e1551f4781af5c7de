package com.jumin.springbootProject.dto;

import com.jumin.springbootProject.entity.MemberEntity;

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
public class MemberDTO {

	private Long id;
	private String email;
	private String password;
	private String name;
	
	public static MemberDTO toMemberDTO(MemberEntity memberEntity) {
		MemberDTO memberDTO = new MemberDTO();
		memberDTO.setId(memberEntity.getId());
		memberDTO.setEmail(memberEntity.getEmail());
		memberDTO.setPassword(memberEntity.getPassword());
		memberDTO.setName(memberEntity.getName());
		System.out.println(memberDTO);
		return memberDTO;
	}
}
