<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/publicCss.css"/>
</head>
<body>
<script>
	function updatePost(){
		document.getElementById("form").submit();
	}
</script>
<div id="mainContainer">
	<jsp:include page="/WEB-INF/view/srv/include/top.jsp" />
	<form method="post" id="form" action="/srv/bbs/updatePost">
		<input id="title" name="title" value=${vo.title } style="width: 400px;"><br/>
		<input type="hidden" id="seq" name = "seq" value="${vo.seq }">
		<textarea rows="20" cols="50" style="width: 400px;" id="contents" name="contents">${vo.contents }</textarea><br />
		<a href="javascript:updatePost();">수정</a>
	</form>
</div>
</body>
</html>