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
			<c:forEach items="${list}" var="li" varStatus="status">
				<tr>
					<td>${paging.startIndex + status.count }</td>
					<td>${li.keyword}</td>
					<td>${li.reg_id}</td>
					<td>${li.reg_date}</td>
					<td><a href="/mng/rule/keywordUpdate?seq=${li.seq }">수정</a></td>
					<td><a href="/mng/rule/keywordDelete?seq=${li.seq }">삭제</a></td>
				</tr>
			</c:forEach>
			<c:if test = "${paging.total eq 0 }">
				<tr>
					<td colspan="6">
						등록된 키워드가 없습니다.
					</td>
				</tr>
			</c:if>
			<tr>
				<td><a href="/mng/rule/keywordInsert">키워드 등록</a></td>
			</tr>
		</table>
		<c:if test="${paging.total > 0 }" >
			<ol class="sortedLi">
				<c:choose>
					<c:when test="${paging.startPage > 1 }">
						<li>
							<a href="/mng/rule/keywordList?nowPage=${paging.nowPage - 1}">&lt;</a>
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
								<a href="/mng/rule/keywordList?nowPage=${p}">${p }</a>
							</c:when>
						</c:choose>
					</li>
				</c:forEach>
				<c:choose>
					<c:when test="${paging.endPage != paging.lastPage}"><!-- 끝페이지가 마지막 페이지보다 작을 경우 다음 페이지범위로 이동 -->
						<li>
							<a href="/mng/rule/keywordList?nowPage=${paging.endPage+1}">&gt;</a>
						</li>
					</c:when>
					<c:otherwise>
						<li>
							<b>&gt;</b>
						</li>
					</c:otherwise>
				</c:choose>
			</ol>
		</c:if>
	</div>
</body>
</html>