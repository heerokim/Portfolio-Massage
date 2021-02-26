package com.example.community.dao;

import java.util.ArrayList;

import com.example.community.vo.MemberVO;

public interface MemberMapper {
	
	/**
	 * 회원가입 기능
	 * @param 회원가입 정보
	 * @return SQL 실행 횟수
	 */
	public int memberInsert(MemberVO member);
	
	/**
	 * 회원조회 기능
	 * @param 입력받은 정보
	 * @return 조회한 정보
	 */
	public MemberVO memberSelectOne(MemberVO member);
	
	/**
	 * 회원 아이디 리스트 조회 기능
	 * @return 회원 아이디 리스트
	 */
	public ArrayList<MemberVO> memberSelectIdList();
}
