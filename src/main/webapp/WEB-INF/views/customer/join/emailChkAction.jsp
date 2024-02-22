<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<!-- 반응형 웹 -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/customer/join.css">

<script src="https://kit.fontawesome.com/b435fbc087.js" crossorigin="anonymous"></script>


<title>이메일 인증</title>

</head>
<body>
	
	<div class="wrap">
		<!-- header 시작  -->
		<%@ include file="/WEB-INF/views/common/header.jsp" %>
		<!-- header 끝  -->
		
		<!-- 컨텐츠 시작 -->
		<!-- 서비스에서 넘어온 값을 받는다. -->
		
		<c:if test="${insertCnt == 1}">
			<script type="text/javascript">
				alert("이메일 인증 성공!!");
				window.location='${path}/login.do';	
			</script>
		</c:if>
		
		<c:if test="${insertCnt != 1}">
			<script type="text/javascript">
				alert("이메일 인증 실패!!");
				window.location='${path}/login.do';	
			</script>
		</c:if>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- footer 끝 -->
	</div>

</body>
</html>