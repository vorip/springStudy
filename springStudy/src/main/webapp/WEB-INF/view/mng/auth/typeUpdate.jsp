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
function typeUpdate(){
	document.getElementById("form").submit();
}
</script>
<form id="form" method="POST">
	typeCode : <input id="typeCode" name="typeCode" type="text" value="${vo.typeCode }">
	typeName : <input id="typeName" name="typeName" type="text" value="${vo.typeName }">
</form>
<a href="javascript:typeUpdate();">수정</a>
</body>
</html>