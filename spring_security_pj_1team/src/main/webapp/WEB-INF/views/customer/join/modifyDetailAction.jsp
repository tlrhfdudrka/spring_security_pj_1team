<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원수정페이지</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
<link rel="stylesheet" href="${path}/resources/css/customer/modifyDetailAction.css" />

<script src="${path}/resources/js/modifyDetailAction.js"></script>
<script src="//t1.daumcdn.net/mapjsapi/bundle/postcode/prod/postcode.v2.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
</head>
<body>
	<div class="wrap">
			<!--header  -->
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
			
			<!--컨텐츠 시작  -->
			<div id="profile-form">
				<div id="contents">
		       <form name=modifyform action="modifyCustomerAction.do" method="post">
		            
		            <c:if test="${selectCnt == 1}">
		            <div class="int-area">
		                <input type="text" name="user_id" id="id" value="${dto.getUser_id()}" autocomplete="off" required>
		                <label for="pw">아이디</label>
		            </div>
		            
		            <div class="int-area">
		                <input type="password" name="user_pwd" id="pw" autocomplete="off" required>
		                <label for="pw">비밀번호</label>
		            </div>
		            <label for="pw" class="pw">-(영문 대소문자/숫자/특수문자 중 2가지 이상 조합,10자~16자)</label>
		           
		            <div class="int-area">
		                <input type="password" name="pw_check" id="pw_check" autocomplete="off" required>
		                <label for="pw_check">비밀번호 확인</label>
		            </div>
		           
		            
		            <div class="int-area">
		                <input type="text" name="user_name" id="name" value="${dto.getUser_name()}" autocomplete="off" required>
		                <label for="name">이름</label>
		            </div>
		            
		            <div class="int-area">
		                <input type="text" name="user_address" id="address" value="${dto.getUser_address()}" autocomplete="off" required>
		                <label for="address">주소</label>
		            </div>
		           
		            <div class=int_mobile_area>
					    <input type="text" name="user_hp" id="mobile" value="${dto.getUser_hp()}" autocomplete="off" required>
					    <label for="mobile">Mobile</label>
					</div>
					
		            <div class="int-area">
		                <input type="text" name="user_email" id="email" value="${dto.getUser_email()}" autocomplete="off" required>
		                <label for="email">이메일</label>
		            </div>
		            
		            <div class="birth-area">
		                <input type="date" name="birth" id="birth" autocomplete="off" required>
		                <label for="birth">생년월일</label>
		            </div>
		            
		            <div class="btn-area">
		                <input class="btn" type="submit" value="회원정보수정">
		                <input class="btn_1" type="submit" value="회원탈퇴">
		                <input class="btn_2" type="reset" value="초기화" >
		            </div>
		        </c:if>
		        
		        <c:if test="${selectCnt != 1}">
		        	<script type="text/javascript">
		        		alert("인증실패");
		        		window.location="modifyCustomer.do"
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