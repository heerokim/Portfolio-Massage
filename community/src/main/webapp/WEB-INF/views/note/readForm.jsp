<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Massage read page</title>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
		<h1> Massage Read </h1>
	</div>
	<div class="body">
		<table class="table">
			<tr>
				<td class="label">
					<label>Send ID</label>
				</td>
				<td>${note.send_id }</td>
			</tr>
			<tr>
				<td class="label">
					<label>Recv ID</label>
				</td>
				<td>${note.recv_id }</td>
			</tr>
			<tr>
				<td class="label">
					<label>Title</label>
				</td>
				<td>${note.note_title }</td>
			</tr>
			<tr>
				<td class="label">
					<label>Content</label>
				</td>
				<td>${note.note_content }</td>
			</tr>
			<tr>
				<td class="button" colspan="2">
					<a class="btn" href="/note/recvListForm">メッセージリストに</a>
				</td>
			</tr>
		</table>
	</div>
</div>			
</body>
</html>