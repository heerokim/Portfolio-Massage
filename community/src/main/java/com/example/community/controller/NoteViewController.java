package com.example.community.controller;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.community.service.MemberService;
import com.example.community.service.NoteService;
import com.example.community.vo.MemberVO;
import com.example.community.vo.NoteVO;

@Controller
@RequestMapping(value="/note")
public class NoteViewController {
	
	@Autowired
	private NoteService noteService;
	@Autowired
	private MemberService memberService;
	
	/**
	 * 쪽지 확인 페이지 이동
	 * @return 응답주소
	 */
	@RequestMapping(value="/list" , method = RequestMethod.GET)
	public String noteList() {
		return "note/list";
	}
	
	/**
	 * 쪽지 작성 페이지 이동
	 * @param 모델객체
	 * @return 응답주소
	 */
	@RequestMapping(value="/writeForm" , method = RequestMethod.GET)
	public String noteWriteForm(Model model) {
		ArrayList<MemberVO> idList = memberService.memberSelectIdList();
		model.addAttribute("idList", idList);
		return "note/writeForm";
	}
	
	/**
	 * 쪽지 쓰기 기능
	 * @param 쪽지 정보
	 * @return 응답주소
	 */
	@RequestMapping(value="/write", method = RequestMethod.POST)
	public String noteWrite(NoteVO note) {
		return noteService.noteWrite(note);
	}
	
	
	/**
	 * 보낸쪽지함 기능
	 * @return 응답주소
	 */
	@RequestMapping(value="/sendListForm", method = RequestMethod.GET)
	public String sendListForm(Model model) {
		ArrayList<HashMap<String, Object>> list = noteService.noteSendList();
		model.addAttribute("list", list);
		return "note/sendListForm";
	}
	
	/**
	 * 받은쪽지함 기능
	 * @return 응답주소
	 */
	@RequestMapping(value="/recvListForm", method = RequestMethod.GET)
	public String recvListForm(Model model) {
		ArrayList<HashMap<String, Object>> list = noteService.noteRecvList();
		model.addAttribute("list", list);
		return "note/recvListForm";
	}
	
	/**
	 * 중요쪽지함 기능
	 * @return 응답주소
	 */	
	@RequestMapping(value="/impListForm", method = RequestMethod.GET)
	public String impListForm(Model model) {
		ArrayList<HashMap<String, Object>> list = noteService.noteImpList();
		model.addAttribute("list", list);
		return "note/impListForm";
	}
	
	@RequestMapping(value="/changeImp", method = RequestMethod.GET)
	public String changeImp(NoteVO note) {
		noteService.changeImp(note);
		return "redirect:/note/list";
	}
	
	@RequestMapping(value="/readForm", method = RequestMethod.GET)
	public String readForm(int note_no, Model model) {
		NoteVO note = noteService.noteSelectOne(note_no);
		model.addAttribute("note", note);
		return "note/readForm";
	}
}
