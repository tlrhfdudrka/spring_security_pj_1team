<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/setting.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<c:if test="${insertCnt == 1}">
		<script>
			setTimeout(function() {
				
				alert("상품 등록 성공");
				window.location="${path}/product_list.pd";
			}, 1000);
		</script>
	</c:if>
	<c:if test="${insertCnt != 1}">
		<script>
			setTimeout(function() {
				
				alert("상품 등록 실패");
				window.location="${path}/product_add.pd";
			}, 1000);
		</script>
	</c:if>
	
</body>
</html>