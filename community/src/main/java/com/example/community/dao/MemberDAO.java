package com.example.community.dao;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community.vo.MemberVO;

@Repository
public class MemberDAO {
	
	@Autowired
	private SqlSession session;

	/**
	 * 회원가입 기능
	 * @param 회원가입 정보
	 * @return SQL 실행 횟수
	 */
	public int memberInsert(MemberVO member) {
		int cnt = 0;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			cnt = mapper.memberInsert(member);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 회원조회 기능
	 * @param 입력받은 정보
	 * @return 조회한 정보
	 */
	public MemberVO memberSelectOne(MemberVO member) {
		MemberVO vo = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			vo = mapper.memberSelectOne(member);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return vo;
	}
	
	/**
	 * 회원 아이디 리스트 조회 기능
	 * @return 회원 아이디 리스트
	 */
	public ArrayList<MemberVO> memberSelectIdList(){
		ArrayList<MemberVO> list = null;
		try {
			MemberMapper mapper = session.getMapper(MemberMapper.class);
			list = mapper.memberSelectIdList();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
}
