<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" type="text/css" href="/css/publicCss.css" />
</head>
<body>
	<div id="mainContainer">
		<jsp:include page="/WEB-INF/view/srv/include/top.jsp" />
		<table>
			<!-- for(BbsVo li : list){  list : List<BbsVo>-->
			<c:forEach items="${list}" var="li" varStatus="status">
				<tr>
					<td>${paging.startIndex + status.count}</td><%-- ${} --%>
					<td><a href="/srv/bbs/viewPost?seq=${li.seq }">${li.title }</a></td>
					<td><c:choose>
							<c:when test="${li.writer eq ''}">
						 		  비회원
							</c:when>
							<c:otherwise>
								${li.writer }
							</c:otherwise>
						</c:choose></td>
					<td>${li.regDate }</td>
				</tr>
			</c:forEach>
				<tr>
					<td></td>
					<td></td>
					<td></td>
					<td><a href="/srv/bbs/write">글쓰기</a></td>
				</tr>
		</table>
		<!-- 현재 페이지가 cntPage(한번에 보여질 페이지 갯수) 보다 클 경우 전 페이지로 이동할 수 있는 링크 활성화 -->
		<ol class="sortedLi">
			<c:choose>
				<c:when test="${paging.startPage > 1 }">
					<li>
						<a href="/srv/bbs/list?nowPage=${paging.nowPage - 1}">&lt;</a>
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
							<a href="/srv/bbs/list?nowPage=${p}">${p }</a>
						</c:when>
					</c:choose>
				</li>
			</c:forEach>
			<c:choose>
				<c:when test="${paging.endPage != paging.lastPage}"><!-- 끝페이지가 마지막 페이지보다 작을 경우 다음 페이지범위로 이동 -->
					<li>
						<a href="/srv/bbs/list?nowPage=${paging.endPage+1}">&gt;</a>
					</li>
				</c:when>
				<c:otherwise>
					<li>
						<b>&gt;</b>
					</li>
				</c:otherwise>
			</c:choose>
		</ol>
	</div>
</body>
</html>