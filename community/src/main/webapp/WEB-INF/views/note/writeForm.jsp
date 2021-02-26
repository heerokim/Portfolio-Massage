<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Massage Write Page</title>
<script type="text/javascript">
function formCheck(){
	var recv_id = document.getElementById("recv_id").value;
	var note_title = document.getElementById("note_title").value;
	var note_content = document.getElementById("note_content").value;

	if(recv_id == 0){
		alert("受信者IDを選択してください。");
		return false;
	}

	if(note_title == null || note_title.length == 0){
		alert("メッセージのタイトルを作成してください。");
		return false;
	}

	if(note_content == null || note_content.length == 0){
		alert("メッセージの内容を作成してください。");
		return false;
	}
	
	return true;
}
</script>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
		<h1>Massage Write</h1>
	</div>
	<div class="body">
		<form action="/note/write" method="post" onsubmit="return formCheck();">
			<table class="table">
				<tr>
					<td class="label">
						<label>Send ID</label>
					</td>
					<td class="input">
						<input class="readonly" type="text" name="send_id" value="${sessionScope.loginVO.member_id }" readonly="readonly">
					</td>
				</tr>
				<tr>
					<td class="label">
						<label>Recv ID</label>
					</td>
					<td class="input">
						<select name="recv_id" id="recv_id">
							<option value="0">--選択してください--</option>
							<c:forEach items="${idList }" var="id">
								<option value="${id.member_id }">${id.member_id }</option>
							</c:forEach>
						</select>
					</td>
				</tr>
				<tr>
					<td class="label">
						<label>Title</label>
					</td>
					<td class="input">
						<input type="text" name="note_title" id="note_title"><br>
					</td>
				</tr>
				<tr>
					<td class="label">
						<label>Content</label>
					</td>
					<td class="input">
						<textarea name="note_content" id="note_content"></textarea>
					</td>
				</tr>
				<tr>
					<td class="button" colspan="2">
						<input class="btn" type="submit" value="転送">
					</td>
				</tr>
			</table>
		</form>
	</div>
</div>
</body>
</html>