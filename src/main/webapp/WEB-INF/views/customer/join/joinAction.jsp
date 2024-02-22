<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<!--반응형 웹  -->
<meta name="viewport" content="width=device-width,initial-scale =1">
<link rel="stylesheet" href="${path}/common/css/header.css">
<link rel="stylesheet" href="${path}/common/css/footer.css">
<link rel="stylesheet" href="${path}/customer/join/css/join.css">
<script src="${path}/customer/join/js/join.js"></script>
</head>
<body>
			<div class="wrap">
			<!--header  -->
			<%@ include file="/WEB-INF/views/common/header.jsp" %>
			
			<!--컨텐츠 시작  -->
			 <c:if test="${insertCnt==1}">
         		<script type="text/javascript">
            		alert("회원가입 성공");
            		 window.location='${path}/login.do';  
        		 </script>
      		</c:if>
     
     		<c:if test="${insertCnt!=1}">
        		 <script type="text/javascript">
           			 alert("회원가입 실패");
           			 window.location='${path}/join.do';
        		 </script>
    		 </c:if>
			
		 <!--footer  -->
		 <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</div>
</body>
</html>