<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리 - 상품 목록</title>
    <link rel="stylesheet" href="${path}/resources/css/admin/product_list.css" />
</head>
<body>

	<div class="pd_list_wrap">	
		<!-- header 시작 -->
		<div class="pd_list_header">
			<%@include file="/WEB-INF/views/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="pd_list_container">
			<div id="pd_list_contents">
				<div id="pd_list_section">
				
					<!-- 좌측메뉴 시작 -->
					<%@ include file="product_menu.jsp" %>			
					<!-- 좌측메뉴 종료 -->
											
					<!-- 우측메뉴 시작 -->
					<div id="pd_list_right">
						<div id="pd_list_right_section">
							<h4>상품목록</h4>
						</div>
						<div class="ad_pd_list_table">
							<form name="ad_pd_list" id="ad_pd_list" method="post">
								<table>
									<tr>
										<th>번호</th>
										<th>상품명</th>
										<th>상품이미지</th>
										<th>판매가격</th>
										<th>재고</th>
										<th>카테고리</th>
										<th>등록일</th>
										<th>수정 / 삭제</th>
									</tr>
									<c:forEach var="dto" items="${list}">
									<tr>
										<td>${dto.pd_num}</td>
										<td>${dto.pd_name}</td>
										<td><img src="${dto.pd_img1}" class="pd_list_img"></td>
										<td>${dto.pd_price}</td>
										<td>${dto.pd_stuck}</td>
										<td>
											<c:if test="${dto.category_num == 1}">Outer</c:if>
											<c:if test="${dto.category_num == 2}">Top</c:if>
											<c:if test="${dto.category_num == 3}">Bottom</c:if>
										</td>
										<td>${dto.pd_register}</td>
										<td>
											<input type="button" value="수정" name="pd_list_btn" id="pd_list_btn" onclick="window.location='${path}/product_listDetail.pd?pd_num=${dto.pd_num}&pageNum=${paging.pageNum}'">/
											<input type="button" value="삭제" name="pd_list_btn" id="pd_delete_btn" onclick="window.location='${path}/product_deleteAction.pd?pd_num=${dto.pd_num}'">
										</td>
									</tr>
									</c:forEach>
									<tr>
										<td colspan="8" align="center">
											<!-- 페이징 처리 -->
											<!-- 이전 버튼 활성화 -->
											<c:if test="${paging.startPage > 10}">
												<a href="${path}/product_list.pd?pageNum=${paging.prev}">◀</a>
											</c:if>
											
											<!-- 페이지 번호 처리 -->
											<c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
												<a href="${path}/product_list.pd?pageNum=${num}">${num}</a>
											</c:forEach>
											
											<!-- 다음 버튼 활성화 -->
											<c:if test="${paging.endPage < paging.pageCount}">
												<a href="${path}/product_list.pd?pageNum=${paging.next}">▶</a>
											</c:if>
										</td>
									</tr>
								</table>							
							</form>
						</div>
					</div>
					<!-- 우측메뉴 종료 -->
				</div>				
			</div>		
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<div class="pd_list_footer">
			<%@ include file= "/WEB-INF/views/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>