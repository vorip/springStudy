<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<script>
function typeInsert(){
	document.getElementById("form").submit();
}
</script>
<body>
<jsp:include page="/WEB-INF/view/mng/auth/top.jsp" />
	<form id="form" method="POST">
		typeCode : <input id="typeCode" name="typeCode" type="text"><br/>
		typeName : <input id="typeName" name="typeName" type="text"><br/>
	</form>
	<a href="javascript:typeInsert();">작성</a>
</body>
</html>