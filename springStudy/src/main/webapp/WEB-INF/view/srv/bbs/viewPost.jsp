<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
function commentInsert(){
	document.getElementById("form").submit();
}
</script>
<link rel="stylesheet" type="text/css" href="/css/publicCss.css"/>
</head>
<body>
	<div id="mainContainer">
		<jsp:include page="/WEB-INF/view/srv/include/top.jsp" />
		제목 : ${vo.title }<br /> 
		작성자 :
		<c:choose>
			<c:when test="${vo.writer == ''}">
		 		  비회원
			</c:when>
			<c:otherwise>
				${vo.writer }
			</c:otherwise>
		</c:choose><br/>
		날짜 : ${vo.regDate }<br/>
		${vo.contents }<br/>
		<a href="/srv/bbs/updatePost?seq=${vo.seq }">수정</a><br/><br/>
		<div id="comment">
			<form id="form" method="POST" action="/srv/bbs/comment">
				<input type="hidden" id="seq" name="seq" value="${vo.seq}">
				<input type="hidden" id="comWriter" name="comWriter" value="${vo.comWriter}">
				<input type="text" id="comContents" name="comContents"><br/>
				<a href="javascript:commentInsert();">작성</a>
			</form>
		</div> 
	</div>
	
</body>
</html>