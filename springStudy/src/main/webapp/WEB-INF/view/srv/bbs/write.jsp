<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/publicCss.css" />
<script>
function postSubmit(){
	document.getElementById("form").submit();
}
</script>
</head>
<body>
	<div id="mainContainer">
		<jsp:include page="/WEB-INF/view/srv/include/top.jsp" />
		<form method="POST" id="form" action="/srv/bbs/write">
			<input type="text" id="title" name="title" style="width: 400px;"><br/>
			<textarea rows="20" cols="50" style="width: 400px;" id="contents" name="contents"></textarea><br />
			<a href="javascript:postSubmit();">작성</a>
			<a href="/srv/bbs/list">뒤로가기</a>
		</form>
	</div>
</body>
</html>