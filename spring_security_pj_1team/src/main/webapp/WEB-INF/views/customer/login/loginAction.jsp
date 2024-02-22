<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>로그인 결과</title>
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
                <div class="caption" >
                <a href="" class="create-account" >SIGN IN</a>
                <a href="join.do" class="create-account_2">CREATE ACCOUNT</a>
                </div>
                
                
                <form name="loginform" action="loginAction.do" method="post" onsubmit="return validateForm()">
                   
                 <c:if test = "${sessionScope.sessionID == null}">
                    <div class="int-area">
                        <input type="text" name="user_id" id="id">
                        <label for="id">Account ID</label>
                        <label for="id"  class="right">Forgot id?</label>
                    </div>
                    	<h5>아이디나 비밀번호가 존재하지 않습니다</h5>
                   
                   
                    <div class="int-area">
                        <input type="password" name="user_pwd" id="pw">
                        <label for="pw">Account Password</label>
                        <label for="pw" class="right">Forgot Password?</label>
                    </div>
                   
                    
                    <div class="btn-area">
                        <button id="button" type="submit" >SIGN IN</button>
                        <button id="button_2" type="reset" >RESET</button>
                    </div>
               </c:if>
               
               <c:if test = "${sessionScope.sessionID != null}">
               
                    <tr>
    <td colspan="2" align="top">
        <h3 class="session-name">
            <span style="color:black"><b>${sessionScope.sessionID}</b></span>님
        </h3>
    </td>
</tr>
                    
                    <tr>
                        <td colspan = "2" style = "border-bottom:none">
                        <br>
                        <div class="btn-area_2">
                            <input class="larger-btn" type="button" value="회원정보수정" onclick="window.location='modifyCustomer.do'">
                            <input class="btn_1" type="button" value="회원탈퇴" onclick="window.location='deleteCustomer.do'">
                            <input class="btn_2" type="button" value="로그아웃" onclick="window.location='logout.do'">
                        </div>
                     </td>
                   </tr>
              </c:if>
            </form>
        </div>
    </div>
</div>
 		<!--footer  -->
        <%@ include file="/WEB-INF/views/common/footer.jsp" %>
</body>
</html>
