<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택주문 결제처리 페이지</title>
</head>
<body>
	<div>
		<c:if test="${updateCnt != 0}">
			<script type="text/javascript">
				alert("결제되었습니다.");
				window.location='${path}/cartList.ct'
			</script>
		</c:if>
		<c:if test="${updateCnt == 0}">
			<script type="text/javascript">
				alert("결제실패");
			</script>
		</c:if>
	</div>
</body>
</html>