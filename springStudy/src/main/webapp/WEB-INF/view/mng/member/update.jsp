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
function memUpdate(){
	document.getElementById("form").submit();
}

</script>
<jsp:include page="/WEB-INF/view/mng/auth/top.jsp" />
	<form id="form" method="POST" action="/mng/member/update">
		아이디 : ${mem.id}<br/>
		<input type="hidden" name="id" value="${mem.id}">
		비밀번호 : <input id="pw" name="pw" type="password"><br/>
		이름 : <input id="name" name="name" type="text" value="${mem.name }"><br/>
	</form>
	<a href="javascript:memUpdate();">변경</a>
</body>
</html>