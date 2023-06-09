package com.jumin.springbootProject.member.dto;

import lombok.Data;

@Data
public class JoinRequest {

	private String id;
	private String name;
	private String phoneNumber;
	private String password;
}
