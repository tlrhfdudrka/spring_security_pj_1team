<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<%-- <link rel="stylesheet" href="${path}/customer/product/us_product/css/product_Outer.css" /> --%>
<title>Insert title here</title>
</head>
<body>

<div class="header-wrap">
	<div class="nav_tab">
	
		<div class="shop">
		<input id="check-btn-shop" type="checkbox" />
		    <label class="menu_shop" for="check-btn-shop">Shop</label>
		      <ul class="menubars-shop">
		          <li><a href="${path}/product_Outer.uspd?category_num=1">Outer</a></li>
		          <li><a href="${path}/product_Top.uspd?category_num=2">Top</a></li>
		          <li><a href="${path}/product_Bottom.uspd?category_num=3">Bottom</a></li>
		          <c:if test="${sessionScope.sessionID == 'admin01'}">
				  	<li><a href="${path}/*.pd">Admin</a></li>
				  </c:if>
		      </ul>
		</div>
		
		<div class="community">   
	    <input id="check-btn-cm" type="checkbox" />
		    <label class="menu_cm" for="check-btn-cm">Community</label>
		      <ul class="menubars-cm">
		        <li><a href="${path}/noticeList.nt">Notice</a></li>
                <li><a href="${path}/board_reviewList.rw">Review</a></li>
		      </ul>
		</div>      
		
		<div class="logo"><a href="${path}/index.do">WITHOUTSUMMER</a></div>      
		
		<div class="account">      
	    <input id="check-btn-ac" type="checkbox" />
		    <label class="menu_ac" for="check-btn-ac">Account</label>
		      <ul class="menubars-ac">
		      	  <c:if test="${sessionScope.sessionID == null}">
				  	<li><a href="${path}/login.do">Login</a></li>
				  	<li><a href="${path}/join.do">Join</a></li>
				  </c:if>
		          <c:if test="${sessionScope.sessionID != null}">
		          	<li><a href="${path}/login.do">Login</a></li>
				  	<li><a href="${path}/logout.do">Logout</a></li>
				  </c:if>
		      </ul>
		 </div>
		<!-- 세션값이 없을때 (로그인 X) -->
		<c:if test="${sessionScope.sessionID == null}">      
			<div class="bag"><a href="${path}/login.do">bag</a></div>
		</c:if>   
		<!-- 세션값이 있을때 (로그인 O) -->
		<c:if test="${sessionScope.sessionID != null}">
			<div class="bag"><a href="${path}/cartList.ct">bag</a></div>
		</c:if>
		
	</div> 
</div>	    
</body>
</html>