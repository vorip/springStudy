<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<script>
var message = '${message}';
if(message.length > 0){
	alert(message);
}
var resUrl = '${resUrl}';
if(resUrl.length > 0){
	location.href= resUrl;
}

function login(){
	document.getElementById("form").submit();
}
</script>
	<form id="form" method="POST" action="/srv/member/login">
		아이디 : <input id="id" type="text" name="id" value="${inputId}">
		비밀번호 : <input id="pw" type="password" name="pw">
	</form>
	<a href="javascript:login();">로그인</a>
</body>
</html>