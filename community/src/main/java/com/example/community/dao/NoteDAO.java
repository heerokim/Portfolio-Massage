package com.example.community.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.community.vo.NoteVO;

@Repository
public class NoteDAO {

	@Autowired
	private SqlSession session;
	
	/**
	 * 쪽지 쓰기 기능
	 * @param 쪽지 정보
	 * @return SQL 실행 횟수
	 */
	public int noteWrite(NoteVO note) {
		int cnt = 0;
		try {
			NoteMapper mapper = session.getMapper(NoteMapper.class);
			cnt = mapper.noteWrite(note);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cnt;
	}
	
	/**
	 * 보낸 쪽지 리스트 조회 기능
	 * @param 발신자 아이디
	 * @return 보낸 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteSendList(String send_id){
		ArrayList<HashMap<String, Object>> list = null;
		try {
			NoteMapper mapper = session.getMapper(NoteMapper.class);
			list = mapper.noteSendList(send_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 받은 쪽지 리스트 조회 기능
	 * @param 수신자 아이디
	 * @return 받은 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteRecvList(String recv_id){
		ArrayList<HashMap<String, Object>> list = null;
		try {
			NoteMapper mapper = session.getMapper(NoteMapper.class);
			list = mapper.noteRecvList(recv_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 중요 쪽지 리스트 조회 기능
	 * @param 수신자 아이디
	 * @return 중요 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteImpList(String recv_id){
		ArrayList<HashMap<String, Object>> list = null;
		try {
			NoteMapper mapper = session.getMapper(NoteMapper.class);
			list = mapper.noteImpList(recv_id);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	/**
	 * 중요 체크 토글 기능
	 * @param 쪽지 정보
	 */
	public void changeImp(NoteVO note) {
		try {
			NoteMapper mapper = session.getMapper(NoteMapper.class);
			mapper.changeImp(note);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 쪽지 읽기 기능
	 * @param 쪽지 번호
	 * @return 쪽지 정보
	 */
	public NoteVO noteSelectOne(int note_no) {
		NoteVO note = null;
		try {
			NoteMapper mapper = session.getMapper(NoteMapper.class);
			note = mapper.noteSelectOne(note_no);
			mapper.noteUpdateRead(note_no);
		}catch (Exception e) {
			e.printStackTrace();
		}
		return note;
	}
}
