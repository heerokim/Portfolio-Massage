<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
	<title>Main Page</title>
	<link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<div class="container">
	<div class="header">
		<h1>
			Happy Massage 
		</h1>
	</div>
	<div class="body">
			<c:choose>
				<c:when test="${empty sessionScope.loginVO }">
					<a class="btn" href="/member/insertForm">会員加入</a>
					<a class="btn" href="/member/loginForm">ログイン</a>
				</c:when>
				<c:otherwise>
					<a class="btn" href="/member/logout">ログアウト</a>
					<a class="btn" href="/note/list">メッセージ</a>
				</c:otherwise>
			</c:choose>
	</div>
</div>

</body>
</html>
