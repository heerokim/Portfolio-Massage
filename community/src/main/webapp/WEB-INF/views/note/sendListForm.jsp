<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send List Page</title>
<script type="text/javascript">
function importantFnc(note_no,note_type){
	location.href = "/note/changeImp?note_no="+note_no+"&note_type="+note_type;
}
</script>
<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div class="noteContainer">
	<div class="header">
		<h1>Send List</h1>
	</div>
	<div class="body">
		<table class="table note">
			<thead>
				<tr>
					<td>重要</td>
					<td>発信者</td>
					<td>タイトル</td>
					<td>常態</td>
					<td>受信日</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${list }" var="note">
				<tr>
					<td>
						<c:choose>
							<c:when test="${note.NOTE_TYPE == 0 }">
								<img class="star" alt="重要" src="/resources/images/unImpStar.png" onclick="importantFnc('${note.NOTE_NO}','${note.NOTE_TYPE }');">
							</c:when>
							<c:otherwise>
								<img class="star" alt="重要" src="/resources/images/impStar.png" onclick="importantFnc('${note.NOTE_NO}','${note.NOTE_TYPE }');">						
							</c:otherwise>
						</c:choose>
					</td>
					<td>${note.MEMBER_NM }</td>
					<td>
						${note.NOTE_TITLE }
					</td>
					<td>${note.NOTE_READ }</td>
					<td>${note.NOTE_DATE }</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5">
					<a class="btn" href="/note/list">リストに</a>
				</td>
			</tr>
			</tbody>
		</table>
	</div>
</div>	
</body>
</html>