<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/setting.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 상세페이지 - Top</title>
	<link rel="stylesheet" href="${path}/resources/css/customer/product_Top_detail.css" />
	<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
    <link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
</head>
<body>
	<div class="detop_wrap">	
		<!-- header 시작 -->
		<div class="detop_header">
			<%@include file="/WEB-INF/views/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="detop_container">
			<div id="detop_contents">
				<div id="detop_section">
					<!-- 우측메뉴 시작 -->
					<div id="detop_right">
						<div class="detop_table_div">
						<br>
							<form name="detop" method="post">
								<ul class="detop_list">
									<li>
										<div class="detop_img1">
										  <img src="${dto.pd_img1}" alt="Avatar" class="detop_image">
										</div>
									</li>
									<li>
										<div class="detop_text1">
										    <div class="detop_text">
										    	${dto.pd_name}<br><br>
										    	${dto.pd_price}<br><br>
										    	<hr><br><br>
										    	<!-- 세션값이 없을때 (로그인 X) -->
												<c:if test="${sessionScope.sessionID == null}">
													<input type="button" value="ADD TO CART" id="detop_cart" onclick="window.location='${path}/login.do'">
												</c:if>	
												<!-- 세션값이 있을때 (로그인 O) -->
												<c:if test="${sessionScope.sessionID != null}">
										    		<input type="button" value="ADD TO CART" id="detop_cart" onclick="window.location='${path}/cart_pdchk_top.ct?pd_num=${dto.pd_num}&user_id=${sessionScope.sessionID}'">
										    	</c:if>
										    	<br>
											    <div class="detop_main">DETAILS</div>
												<div class="detop_sub">
												  	${dto.pd_content}
												</div>
												<div class="detop_main">SIZE GUIDE</div>
												<div class="detop_sub">
													FITTING SIZE : FREE
												</div>
												<div class="detop_main">SHOPPING</div>
												<div class="detop_sub">
												  	택배사 : CJ대한통운<br><br>
													- 배송 기간 : 평균 2-5일 소요<br>
													 택배사 상황에 따라 배송 일정 변경 될 수 있습니다.
												</div>
												<div class="detop_main">NOTICE</div>
												<div class="detop_sub">
												  	주소 : 03708 서울특별시 서대문구 연희맛로 2-3 2층 위드아웃썸머
												</div>
										  </div>
										  <hr>
										</div>
									</li>
								</ul>
								<ul class="detop_list">
									<li>
										<div class="detop_img2">
										  <img src="${dto.pd_img1}" alt="Avatar" class="detop_image">
										</div>
									</li>
								</ul>
								<ul class="detop_list">
									<li>
										<div class="detop_img2">
										  <img src="${dto.pd_img2}" alt="Avatar" class="detop_image">
										</div>
									</li>
								</ul>
								<ul class="detop_list">
									<li>
										<div class="detop_img2">
										  <img src="${dto.pd_detail_img}" alt="Avatar" class="detop_image">
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
		<div class="ad_detop_footer">
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>
</body>
</html>