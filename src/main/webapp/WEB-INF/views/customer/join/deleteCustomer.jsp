<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원탈퇴인증-화면</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
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
				
		        <form name="loginform" action="deleteCustomerAction.do" method="post">
		        
		        <!-- 각 jsp의 form 태그 아래에 _csrf 지정을 안하면 권한 에러발생시켜 관리자 페이지로 이동하도록 함 -->
		        <!-- post 방식일때 method="post" 반드시 추가된 상태에서 -->
		        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"> 
		           
		           <span style="color:black"><b>${sessionID}</b></span>님 비밀번호를 입력하세요
		            <div class="int-area">
		                <input type="password" name="user_pwd" id="pw">
		                <label for="pw">Account Password</label>
		            </div>
		            
		           
		            <div class="btn-area">
		                <button id="button" type="submit" >회원탈퇴</button>
		                <button id="button_2" type="submit" onclick="common/index.do">탈퇴취소</button>
		            </div>
		</form>
	</div>
</div>
</div>
		<!--footer  -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>