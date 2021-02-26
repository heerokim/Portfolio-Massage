package com.example.community.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.example.community.vo.NoteVO;

public interface NoteMapper {

	/**
	 * 쪽지 쓰기 기능
	 * @param 쪽지 정보
	 * @return SQL 실행 횟수
	 */
	public int noteWrite(NoteVO note);
	
	/**
	 * 보낸 쪽지 리스트 조회 기능
	 * @param 발신자 아이디
	 * @return 보낸 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteSendList(String send_id);
	
	/**
	 * 받은 쪽지 리스트 조회 기능
	 * @param 수신자 아이디
	 * @return 받은 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteRecvList(String recv_id);

	/**
	 * 중요 쪽지 리스트 조회 기능
	 * @param 수신자 아이디
	 * @return 중요 쪽지 리스트
	 */
	public ArrayList<HashMap<String, Object>> noteImpList(String recv_id);
	
	/**
	 * 중요 체크 토글 기능
	 * @param 쪽지 정보
	 */
	public void changeImp(NoteVO note);
	
	/**
	 * 쪽지 읽기 기능
	 * @param 쪽지 번호
	 * @return 쪽지 정보
	 */
	public NoteVO noteSelectOne(int note_no);
	
	/**
	 * 쪽지 읽기 처리 기능
	 * @param 쪽지 번호
	 */
	public void noteUpdateRead(int note_no);
}
