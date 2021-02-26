create table note_tb(
	note_no			number		PRIMARY KEY
	,send_id		varchar2(30)		NOT NULL
	,recv_id			varchar2(30)		NOT NULL
	,note_title		varchar2(200)	NOT NULL
	,note_content	varchar2(3000)		NOT NULL
	,note_type			char(1)			DEFAULT 0
	,note_read			char(1)			DEFAULT 0
	,note_date			date				DEFAULT sysdate
	,constraint note_fk1 foreign key(send_id)
		references member_tb(member_id)
	,constraint note_fk2 foreign key(recv_id)
		references member_tb(member_id)	
);

CREATE SEQUENCE note_seq;
