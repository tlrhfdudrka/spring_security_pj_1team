<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/setting.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세페이지 - Bottom</title>
	<link rel="stylesheet" href="${path}/resources/css/customer/product_Bottom_detail.css" />
	<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
    <link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
</head>
<body>
	<div class="debottom_wrap">	
		<!-- header 시작 -->
		<div class="debottom_header">
			<%@include file="/WEB-INF/views/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="debottom_container">
			<div id="debottom_contents">
				<div id="debottom_section">
					<!-- 우측메뉴 시작 -->
					<div id="debottom_right">
						<div class="debottom_table_div">
						<br>
							<form name="debottom" method="post">
								<ul class="debottom_list">
									<li>
										<div class="debottom_img1">
										  <img src="${dto.pd_img1}" alt="Avatar" class="debottom_image">
										</div>
									</li>
									<li>
										<div class="debottom_text1">
										    <div class="debottom_text">
										    	${dto.pd_name}<br><br>
										    	${dto.pd_price}<br><br>
										    	<hr><br>
												<br>  	
										    	<!-- 세션값이 없을때 (로그인 X) -->
												<c:if test="${sessionScope.sessionID == null}">
													<input type="button" value="ADD TO CART" id="debottom_cart" onclick="window.location='${path}/login.do'">
												</c:if>
												<!-- 세션값이 있을때 (로그인 O) -->
												<c:if test="${sessionScope.sessionID != null}">
													<input type="button" value="ADD TO CART" id="debottom_cart" onclick="window.location='${path}/cart_pdchk_bottom.ct?pd_num=${dto.pd_num}&user_id=${sessionScope.sessionID}'">
												</c:if>
										    	<br>
											
											    <div class="debottom_main">DETAILS</div>
												<div class="debottom_sub">
												  	${dto.pd_content}
												</div>
												<div class="debottom_main">SIZE GUIDE</div>
												<div class="debottom_sub">
													FITTING SIZE : FREE
												</div>
												<div class="debottom_main">SHOPPING</div>
												<div class="debottom_sub">
												  	택배사 : CJ대한통운<br><br>
													- 배송 기간 : 평균 2-5일 소요<br>
													 택배사 상황에 따라 배송 일정 변경 될 수 있습니다.
												</div>
												<div class="debottom_main">NOTICE</div>
												<div class="debottom_sub">
												  	주소 : 03708 서울특별시 서대문구 연희맛로 2-3 2층 위드아웃썸머
												</div>
										  </div>
										  <hr>
										</div>
									</li>
								</ul>
								<ul class="debottom_list">
									<li>
										<div class="debottom_img2">
										  <img src="${dto.pd_img1}" alt="Avatar" class="debottom_image">
										</div>
									</li>
								</ul>
								<ul class="debottom_list">
									<li>
										<div class="debottom_img2">
										  <img src="${dto.pd_img2}" alt="Avatar" class="debottom_image">
										</div>
									</li>
								</ul>
								<ul class="debottom_list">
									<li>
										<div class="debottom_img2">
										  <img src="${dto.pd_detail_img}" alt="Avatar" class="debottom_image">
										</div>
									</li>
								</ul>
							</form>
						</div>
					</div>
					<!-- 우측메뉴 종료 -->
				</div>				
			</div>		
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<div class="debottom_footer">
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>
</body>
</html>