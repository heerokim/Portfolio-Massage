package com.example.community.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.community.service.MemberService;
import com.example.community.vo.MemberVO;

@Controller
@RequestMapping(value="/member")
public class MemberViewController {
	
	@Autowired
	private MemberService service;

	/**
	 * 회원 가입 페이지 이동
	 * @return 응답주소
	 */
	@RequestMapping(value="/insertForm", method = RequestMethod.GET)
	public String memberInsertForm() {
		return "member/insertForm";
	}
	
	/**
	 * 회원가입 기능
	 * @param 회원가입 정보
	 * @return 응답주소
	 */
	@RequestMapping(value="/insert" , method = RequestMethod.POST)
	public String memberInsert(MemberVO member) {
		return service.memberInsert(member);
	}
	
	
	/**
	 * 로그인 페이지 이동
	 * @return 응답주소
	 */
	@RequestMapping(value="/loginForm" , method = RequestMethod.GET)
	public String memberLoginForm() {
		return "member/loginForm";
	}
	
	/**
	 * @param 입력받은 회원정보
	 * @return 응답주소
	 */
	@RequestMapping(value="/login" , method = RequestMethod.POST)
	public String memberLogin(MemberVO member) {
		return service.memberLogin(member);
	}
	
	/**
	 * 로그아웃 기능
	 * @return 응답주소
	 */
	@RequestMapping(value="/logout" , method = RequestMethod.GET)
	public String memberLogout() {
		return service.memberLogout();
	}
	
}


