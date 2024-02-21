<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>     
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니 상품 중복확인 처리 페이지(top)</title>
</head>
<body>
	<c:if test="${selectCnt == 1}">
		<script type="text/javascript">
			alert("이미 장바구니에 담은 상품입니다.\n 장바구니로 이동>>");
			window.location="${path}/cartList.ct";
		</script>
	</c:if>
	
	<c:if test="${selectCnt != 1}">
		<script type="text/javascript">
			window.location="${path}/cartAddAction.ct?pd_num=${pd_num}";
		</script>
	</c:if>
</body>
</html>