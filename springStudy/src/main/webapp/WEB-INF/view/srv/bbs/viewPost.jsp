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
function commentDelete(comSeq){
	document.getElementById("comSeq").value=comSeq;
	document.getElementById("form").action="/srv/bbs/delCom";
	
	document.getElementById("form").submit();
}
function commentUpdate(comSeq){
	window.open("/srv/bbs/updateCom?comSeq="+comSeq);
}
</script>
<link rel="stylesheet" type="text/css" href="/css/publicCss.css"/>
</head>
<body>
	<div id="mainContainer">
		<jsp:include page="/WEB-INF/view/srv/include/top.jsp" />
		<div id="con">
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
			<a href="/srv/bbs/updatePost?seq=${vo.seq }">수정</a>
			<a href="/srv/bbs/delete?seq=${vo.seq }">삭제</a><br/><br/>
			<div id="comment">
				<table>
					<c:forEach items="${comList}" var="li" varStatus="status">
						<tr>
							<td>
								${li.comContents }
							</td>
							<td>
								<c:choose>
									<c:when test="${li.comWriter == ''}">
								 		  비회원
									</c:when>
									<c:otherwise>
										${li.comWriter }
									</c:otherwise>
								</c:choose><br/>
							</td>
							<td>${li.regDate }</td>
							<td><a href="javascript:commentUpdate(${li.comSeq });">수정</a></td>
							<td><a href="javascript:commentDelete(${li.comSeq });">삭제</a></td>
						</tr>
					</c:forEach>
				</table>
				<ol class="sortedLi">
				<c:choose>
					<c:when test="${paging.startPage > 1 }">
						<li>
							<a href="/srv/bbs/viewPost?seq=${vo.seq}&nowPage=${paging.nowPage - 1}">&lt;</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<b>&lt;</b>
						</li>
					</c:otherwise>
				</c:choose>
				<!-- for(int p=paging.startPage;p<=paging.endPage;p++) -->
				<c:forEach begin="${paging.startPage }" end="${paging.endPage }" var="p"> <!-- 페이지 출력을 위한 반복문 -->
					<li>
						<c:choose>
							<c:when test="${p == paging.nowPage }"><!-- 현재페이지인 경우에 링크 비활성화  -->
								<b>${p }</b>
							</c:when>
							<c:when test="${p != paging.nowPage }"><!-- 현재페이지가 아닐 경우 링크 활성화 -->
								<a href="/srv/bbs/viewPost?seq=${vo.seq}&nowPage=${p}">${p }</a>
							</c:when>
						</c:choose>
					</li>
				</c:forEach>
				<c:choose>
					<c:when test="${paging.endPage != paging.lastPage}"><!-- 끝페이지가 마지막 페이지보다 작을 경우 다음 페이지범위로 이동 -->
						<li>
							<a href="/srv/bbs/viewPost?seq=${vo.seq}&nowPage=${paging.endPage+1}">&gt;</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<b>&gt;</b>
						</li>
					</c:otherwise>
				</c:choose>
			</ol>
				<form id="form" method="POST" action="/srv/bbs/comInsert">
					<input type="hidden" id="comSeq" name="comSeq" value="${vo.comSeq}" />
					<input type="hidden" id="seq" name="seq" value="${vo.seq}">
					<input type="hidden" id="comWriter" name="comWriter" value="${vo.comWriter}">
					<input type="text" id="comContents" name="comContents"><br/>
					<a href="javascript:commentInsert();">작성</a>
				</form>
			</div> 
		</div>
</div>
	
</body>
</html>