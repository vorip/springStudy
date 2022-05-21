<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
if("${url}" != ""){
	opener.location.href="${url}";
	window.close();
}
function commentUpdate(){
	document.getElementById("updateCom").submit();
}
</script>
</head>
<body>
<form id="updateCom" method="POST" action="/srv/bbs/updateCom">
	<input type="hidden" id="comSeq" name="comSeq" value="${vo.comSeq}" />
	<input type="hidden" id="seq" name="seq" value="${vo.seq}">
	<input type="text" id="comContents" name="comContents" value="${vo.comContents}"><br/>
	<a href="javascript:commentUpdate();">작성</a>
</form>
</body>
</html>