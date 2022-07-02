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
		function postSubmit(){
			document.getElementById("form").submit();
		}
	</script>
	<form id="form" method="post" action="/mng/rule/keywordUpdate">
		<input id="seq" name="seq" type="hidden" value="${vo.seq}">
		<input id="keyword" name="keyword" type="text" value="${vo.keyword}">
		<a href="javascript:postSubmit()">수정</a>
	</form>
</body>
</html>