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
function signUp(){
	document.getElementById("form").submit();
}
</script>
	<form id="form" method="POST" action="/srv/member/signUp">
		아이디 : <input type="text" id="id" name="id" value="${vo.id}"><br/>
		비밀번호 : <input type="password" id="pw" name="pw" value="${vo.pw}"><br/>
		이름 : <input type="text" id="name" name="name" value="${vo.name}">
	</form>
	<a href="javascript:signUp();">회원가입</a>
</body>
</html>