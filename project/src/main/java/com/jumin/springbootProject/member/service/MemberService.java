package com.jumin.springbootProject.member.service;

public interface MemberService {

	String login(String id, String password );

	String join(String id, String name, String phoneNumber, String password);
}
