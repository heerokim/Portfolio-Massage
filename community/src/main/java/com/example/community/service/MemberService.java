package com.example.community.service;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.community.dao.MemberDAO;
import com.example.community.vo.MemberVO;

@Service
public class MemberService {

	@Autowired
	private MemberDAO dao;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 회원가입 기능
	 * @param 회원가입 정보
	 * @return 응답주소
	 */
	public String memberInsert(MemberVO member) {
		int cnt = dao.memberInsert(member);
		String path = cnt > 0 ? "redirect:/" : "redirect:/member/insertForm";
		return path;
	}
	
	/**
	 * 로그인 기능
	 * @param 입력받은 회원정보
	 * @return 응답주소
	 */
	public String memberLogin(MemberVO member) {
		MemberVO vo = dao.memberSelectOne(member);
		String path = "";
		if(vo != null) {
			session.setAttribute("loginVO", vo);
			path = "redirect:/";
		} else {
			path = "redirect:/member/loginForm";
		}
		return path;
	}
	
	/**
	 * 로그아웃 기능
	 * @return 응답주소
	 */
	public String memberLogout() {
		session.removeAttribute("loginVO");
		return "redirect:/";
	}
	
	/**
	 * 회원 아이디 리스트 조회 기능
	 * @return 회원 아이디 리스트
	 */
	public ArrayList<MemberVO> memberSelectIdList(){
		return dao.memberSelectIdList();
	}
	
}
