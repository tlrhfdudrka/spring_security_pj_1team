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
		           
		           <span style="color:black"><b>${sessionID}</b></span>님 비밀번호를 입력하세요
		            <div class="int-area">
		                <input type="password" name="user_pwd" id="pw">
		                <label for="pw">Account Password</label>
		            </div>
		            
		           
		            <div class="btn-area">
		                <button id="button" type="submit" >회원탈퇴</button>
		                <button id="button_2" type="reset" onclick="main()">탈퇴취소</button>
		            </div>
		</form>
	</div>
</div>
</div>
		<!--footer  -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>