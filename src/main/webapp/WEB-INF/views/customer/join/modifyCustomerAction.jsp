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
		        
		        <!-- 각 jsp의 form 태그 아래에 _csrf 지정을 안하면 권한 에러발생시켜 관리자 페이지로 이동하도록 함 -->
		        <!-- post 방식일때 method="post" 반드시 추가된 상태에서 -->
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}">   
		           
		           <c:if test = "${updateCnt == 1}">
		            	<script type="text/javascript">
		            		alert("회원수정 성공");
		            		window.location="index.do";
		            	</script>
		            </c:if>
		            
		            <c:if test = "${updateCnt != 1}">
		            	<script type="text/javascript">
		            		alert("회원수정 실패");
		            		window.location="modifyDetailAction.do";
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