package com.example.community.service;

import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.community.dao.NoteDAO;
import com.example.community.vo.MemberVO;
import com.example.community.vo.NoteVO;

@Service
public class NoteService {

	@Autowired
	private NoteDAO dao;
	
	@Autowired
	private HttpSession session;
	
	/**
	 * 쪽지 쓰기 기능
	 * @param 쪽지 정보
	 * @return 응답주소
	 */
	public String noteWrite(NoteVO note) {
		int cnt = dao.noteWrite(note);
		String path = cnt > 0 ? "redirect:/note/list" : "redirect:/note/writeForm";
		return path;
	}
	
	/**
	 * 보낸 쪽지 리스트 조회 기능
	 * @param 발신자 아이디
	 * @return 보낸 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteSendList(){
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		ArrayList<HashMap<String, Object>> list = dao.noteSendList(loginVO.getMember_id());
		return list;
	}
	
	/**
	 * 받은 쪽지 리스트 조회 기능
	 * @param 수신자 아이디
	 * @return 받은 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteRecvList(){
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		ArrayList<HashMap<String, Object>> list = dao.noteRecvList(loginVO.getMember_id());
		return list;
	}
	
	/**
	 * 중요 쪽지 리스트 조회 기능
	 * @param 수신자 아이디
	 * @return 중요 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteImpList(){
		MemberVO loginVO = (MemberVO)session.getAttribute("loginVO");
		ArrayList<HashMap<String, Object>> list = dao.noteImpList(loginVO.getMember_id());
		return list;
	}
	
	/**
	 * 중요 체크 토글 기능
	 * @param 쪽지 정보
	 * @return 응답주소
	 */
	public void changeImp(NoteVO note) {
		if(note.getNote_type().equals("0")) {
			note.setNote_type("1");
		} else {
			note.setNote_type("0");
		}
		dao.changeImp(note);
	}
	
	/**
	 * 쪽지 읽기 기능
	 * @param 쪽지 번호
	 * @return 쪽지 정보
	 */
	public NoteVO noteSelectOne(int note_no) {
		return dao.noteSelectOne(note_no);
	}
}
