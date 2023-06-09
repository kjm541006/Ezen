package com.jumin.springbootProject.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.jumin.springbootProject.dto.MemberDTO;

import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter
@Table(name = "member")
public class MemberEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column(unique = true)
	private String email;
	
	private String password;
	
	private String name;
	
	public static MemberEntity toMemberEntity(MemberDTO memberDTO) {
		MemberEntity memberEntity = new MemberEntity();
		memberEntity.setEmail(memberDTO.getEmail());
		memberEntity.setPassword(memberDTO.getPassword());
		memberEntity.setName(memberDTO.getName());
		return memberEntity;
		
	}
	
}
