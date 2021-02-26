package com.example.community.vo;

import lombok.Data;

@Data
public class NoteVO {
	private int note_no;
	private String send_id;
	private String recv_id;
	private String note_title;
	private String note_content;
	private String note_type;
	private String note_read;
	private String note_date;
}
