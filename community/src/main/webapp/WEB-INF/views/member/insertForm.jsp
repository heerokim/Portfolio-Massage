<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Join Page</title>
<script type="text/javascript">
function formCheck(){
	var id = document.getElementById("member_id").value;
	var pw = document.getElementById("member_pw").value;
	var pwCheck = document.getElementById("pw_check").value;
	var nm = document.getElementById("member_nm").value;

	if(id == null || id.length == 0){
		alert("IDを入力してください。");
		return false;
	}else if(id.length < 3 || id.length > 8){
		alert("IDは3文字~8文字で入力してください。");
		return false;
	}

	if(pw == null || pw.length == 0){
		alert("パスワードをご入力ください。");
		return false;
	}else if(pw.length < 3 || pw.length > 8){
		alert("パスワードは3文字~8文字で入力してください。");
		return false;
	}else if(pw != pwCheck){
		alert("同じパスワードを入力してください。");
		return false;
	}

	if(nm == null || nm.length == 0){
		alert("名前を入力してください。");
		return false;
	}else if(nm.length < 2 || nm.length > 4){
		alert("名前は2文字~4文字で入力してください。");
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
		<h1>Sign Up</h1>
	</div>
	<div class="body">
		<form action="/member/insert" method="post" onsubmit="return formCheck();">
			<table class="table">
				<tr>
					<td class="label">
						<label>ID</label>
					</td>
					<td class="input">
						<input type="text" name="member_id" id="member_id">
					</td>
				</tr>
				<tr>
					<td class="label">
						<label>PW</label>
					</td>
					<td class="input">
						<input type="password" name="member_pw" id="member_pw">
					</td>
				</tr>
				<tr>
					<td class="label">
						<label>PW Check</label>
					</td>
					<td class="input">
						<input type="password" id="pw_check">
					</td>
				</tr>
				<tr>
					<td class="label">
						<label>Name</label>
					</td>
					<td class="input">
						<input type="text" name="member_nm" id="member_nm">
					</td>
				</tr>
				<tr>
					<td class="button" colspan="2">
						<input class="btn" type="submit" value="会員加入">
					</td>
				</tr>
			</table>
		</form>	
	</div>
</div>	
</body>
</html>