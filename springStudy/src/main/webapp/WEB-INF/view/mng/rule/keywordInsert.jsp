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
	function keywordSubmit(){
		document.getElementById("form").submit();
	}
	</script>
	<form method="post" id="form" action="/mng/rule/keywordInsert">
		검색어 : <input id="keyword" type="text" name="keyword">
		<a href="javascript:keywordSubmit()">등록</a>
	</form>
</body>
</html>