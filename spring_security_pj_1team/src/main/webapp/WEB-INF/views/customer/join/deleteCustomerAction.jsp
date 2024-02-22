<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴-인증화면</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
<link rel="stylesheet" href="${path}/resources/css/customer/login.css" />
<link rel="stylesheet" href="${path}/resources/css/customer/loginAction.css" />
<script src="${path}/resources/js/login.js"></script>

</head>
<body>
	<div class="wrap">
			<!--header  -->
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
			
			<!--컨텐츠 시작  -->
			
			<div id="login-form">
				<div id="contents">
		        <form name="deleteform" method="post">
		           
		           <c:if test = "${deleteCnt == 1}">
		            	<script type="text/javascript">
		            		alert("회원탈퇴 성공");
		            		window.location="index.do";
		            	</script>
		            </c:if>
		            
		            <c:if test = "${deleteCnt != 1}">
		            	<script type="text/javascript">
		            		alert("회원탈퇴 실패");
		            		window.location="deleteCustomer.do";
		            	</script>
		            </c:if>
		</form>
	</div>
</div>
		<!--footer  -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
</body>
</html>