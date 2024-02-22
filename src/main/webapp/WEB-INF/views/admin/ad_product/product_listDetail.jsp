<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리 - 상품 상세페이지</title>
    <link rel="stylesheet" href="${path}/resources/css/admin/product_listDetail.css" />
</head>
<body>
	<div class="pd_DeList_wrap">	
		<!-- header 시작 -->
		<div class="pd_DeList_header">
			<%@include file="/WEB-INF/views/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="pd_DeList_container">
			<div id="pd_DeList_contents">
				<div id="pd_DeList_section">
				
					<!-- 좌측메뉴 시작 -->
					<%@ include file="product_menu.jsp" %>	
					<!-- 좌측메뉴 종료 -->
					
					<!-- 우측메뉴 시작 -->
					<div id="pd_DeList_right">
						<div id="pd_DeList_right_section">
							<h4>상품 상세페이지</h4>
						</div>
						<div class="pd_DeList_table_div">
							<form action="product_editAction.pd" name="ad_pd_DeList" method="post"  enctype="multipart/form-data">
			                    <table> 
			                    	<input type="hidden" name="hiddenPdNum" value="${dto.pd_num}">  
			                    	<input type="hidden" name="hiddenPageNum" value="${pageNum}">
									<input type="hidden" name="hiddenPdImg1" value="${dto.pd_img1}">
									<input type="hidden" name="hiddenPdImg2" value="${dto.pd_img2}">
									<input type="hidden" name="hiddenPdImgDe" value="${dto.pd_detail_img}">
									
			                    	<tr>
			                            <th>상품번호</th>
			                            <td>
			                            	${dto.pd_num}
			                            </td>
			                        </tr>                      
			                         <tr>
			                            <th>상품명</th>
			                            <td>
			                                <input type="text" name="pd_name" id="pd_DeList_name" value="${dto.pd_name}" required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>상품이미지1</th>
			                            <td colspan="2">
			                            	<img src="${dto.pd_img1}" class="pd_DeList_img"><br>
											<input type="file" name="pd_img1" id="pd_DeList_file1" accept="image/*">
										</td>
			                        </tr>
			                         <tr>
			                            <th>상품이미지2</th>
			                            <td colspan="2">
			                            	<img src="${dto.pd_img2}" class="pd_DeList_img"><br>
											<input type="file" name="pd_img2" id="pd_DeList_file2" accept="image/*">
										</td>
			                        </tr>
			                        <tr>
			                            <th>상품상세이미지</th>
			                            <td colspan="2">
			                            	<img src="${dto.pd_detail_img}" class="pd_DeList_img"><br>
											<input type="file" name="pd_detail_img" id="pd_DeList_defile" accept="image/*">
										</td>
			                        </tr>
			                        <tr>
			                            <th>판매가격</th>
			                            <td>
			                                <input type="text" name="pd_price" id="pd_DeList_price" value="${dto.pd_price}" required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>재고</th>
			                            <td>
			                                <input type="text" name="pd_stuck" id="pd_DeList_cnt" value="${dto.pd_stuck}" required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>카테고리</th>
			                            <td>
			                                <select id="category_num" name="category_num">
												<option >카테고리 선택</option>
												<option <c:if test="${dto.category_num=='1'}">selected</c:if> value="Outer">Outer</option>
												<option <c:if test="${dto.category_num=='2'}">selected</c:if> value="Top">Top</option>
												<option <c:if test="${dto.category_num=='3'}">selected</c:if> value="Bottom">Bottom</option>
											</select>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>설명</th>
			                            <td colspan="2">
											<textarea rows="8" cols="70" name="pd_content" id="pd_DeList_ex">${dto.pd_content}</textarea>
										</td>
			                        </tr>
			                        <tr>
		                             <td colspan="2" align="center">
		                                   <input class="pd_DeList_btn" type="submit" value="수정" onclick="window.location='${path}/product_editAction.pd'">
		                                   <input class="pd_DeList_btn" type="reset" value="초기화">
		                                   <input class="pd_DeList_btn" type="button" value="목록" onclick="window.location='${path}/product_list.pd'">
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
		<div class="pd_add_footer">
			<%@ include file= "/WEB-INF/views/common/footer.jsp" %>
		</div>
		<!-- footer 끝 -->
	</div>

</body>
</html>