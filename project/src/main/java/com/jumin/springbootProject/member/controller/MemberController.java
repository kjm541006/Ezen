package com.jumin.springbootProject.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.jumin.springbootProject.member.dto.JoinRequest;
import com.jumin.springbootProject.member.dto.LoginRequest;
import com.jumin.springbootProject.member.service.MemberService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class MemberController {
	// 생성자주입
	private final MemberService memberService;

	@GetMapping("/member/hello")
	public ModelAndView getHello() {
		ModelAndView mav = new ModelAndView("html/hello");
		return mav;

	}
	
	@GetMapping("/member/join")
	public ModelAndView getJoin() {
		ModelAndView mav = new ModelAndView("html/join");
		return mav;
		
	}
	
	@PostMapping("/member/join")
	public ModelAndView join(JoinRequest joinRequest) {
		String id = joinRequest.getId();
		String name = joinRequest.getName();
		String phoneNumber = joinRequest.getPhoneNumber();
		String password = joinRequest.getPassword();
		
		String result = memberService.join(id, name, phoneNumber, password);
		
		System.out.println(result);
		
		ModelAndView mavSuccess = new ModelAndView("html/joinSuccess");
		ModelAndView mavFail = new ModelAndView("html/joinFail");
		
		if(result.equalsIgnoreCase("success")) {
			return mavSuccess;
		}else {
			return mavFail;
		}
		
	}
	
	@GetMapping("/member/login")
	public ModelAndView getLogin() {
		ModelAndView mav = new ModelAndView("html/login");
		return mav;
	}
	
	@PostMapping("/member/login")
	public String login(LoginRequest loginRequest) {
		String id = loginRequest.getId();
		String password = loginRequest.getPassword();
		
		String result = memberService.login(id, password);
		
		System.out.println(result);
		if(result != null) {
			return "success";
		}else {
			return "fail";
		}
		
	}
}
