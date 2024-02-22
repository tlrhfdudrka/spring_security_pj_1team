<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 목록 - Bottom</title>
	<link rel="stylesheet" href="${path}/resources/css/customer/product_Bottom.css" />
	<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
    <link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
    <script>
	    function goToProductDetail(pdNum, pageNum) {
	    	
	        window.location = "${path}/product_Bottom_detail.uspd?pd_num=" + pdNum + "&pageNum=" + pageNum;
	    }
	</script>
</head>
<body>

	<div class="bottom_wrap">	
		<!-- header 시작 -->
		<div class="bottom_header">
			<%@include file="/WEB-INF/views/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="bottom_container">
			<div id="bottom_contents">
				<div id="bottom_section">
											
					<!-- 우측메뉴 시작 -->
					<div id="bottom_right">
						<div class="bottom_table_div">
						<br>
						<h4>Bottom</h4>
							<form name="bottom" method="post">
								<ul class="bottom_list">
									<c:forEach var="dto" items="${list}">
										<c:if test="${dto.category_num == 3}">
										<li>
											<div class="bottom_img" onclick="goToProductDetail(${dto.pd_num}, ${paging2.pageNum})">
											  <img src="${dto.pd_img1}" alt="Avatar" class="bottom_image" >
											  <div class="bottom_overlay">
											    <div class="bottom_ex">
												    <img src="${dto.pd_img2}" alt="Avatar" class="bottom_image"><br>
												    	${dto.pd_name}<br>
												    	${dto.pd_price}
											    </div>
											  </div>
											</div>
										</li>
										</c:if>
									</c:forEach>
								</ul>
								<ul>
									<li id="uspd_bottom_page">
										<!-- 페이징 처리 -->
										<!-- 이전 버튼 활성화 -->
										<c:if test="${paging2.startPage > 10}">
											<a href="${path}/product_Bottom.uspd?category_num=3&pageNum=${paging2.prev}">◀</a>
										</c:if>
										
										<!-- 페이지 번호 처리 -->
										<c:forEach var="num" begin="${paging2.startPage}" end="${paging2.endPage}">
											<a href="${path}/product_Bottom.uspd?category_num=3&pageNum=${num}">${num}</a>
										</c:forEach>
										
										<!-- 다음 버튼 활성화 -->
										<c:if test="${paging2.endPage < paging2.pageCount}">
											<a href="${path}/product_Bottom.uspd?category_num=3&pageNum=${paging2.next}">▶</a>
										</c:if>
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
		<div class="bottom_footer">
			<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>