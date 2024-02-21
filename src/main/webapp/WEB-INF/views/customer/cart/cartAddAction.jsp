<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 상품추가 처리 페이지</title>
</head>
<body>
	<c:if test="${insertCnt == 1}">
		<script type="text/javascript">
			alert("장바구니에 추가되었습니다.\n 장바구니로 이동 >>");
			window.location="${path}/cartList.ct";
		</script>
	</c:if>
	
	<c:if test="${insertCnt != 1}">
		<script type="text/javascript">
			alert("장바구니 상품추가 실패");
			window.location="${path}/cartList.ct";
		</script>
	</c:if>
</body>
</html>