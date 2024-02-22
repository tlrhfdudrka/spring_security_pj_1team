<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/setting.jsp" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>상품 관리 - 상품 등록</title>
	<link rel="stylesheet" href="${path}/resources/css/admin/product_add.css" />
</head>
<body>

	<div class="pd_add_wrap">	
		<!-- header 시작 -->
		<div class="pd_add_header">
			<%@include file="/WEB-INF/views/common/header.jsp" %>
		</div>	
		<!-- header 끝 -->
		
		<!-- 컨텐츠 시작 -->
		<div id="pd_add_container">
			<div id="pd_add_contents">
				<div id="pd_add_section">
				
					<!-- 좌측메뉴 시작 -->
					<%@ include file="product_menu.jsp" %>	
					<!-- 좌측메뉴 종료 -->
					
					<!-- 우측메뉴 시작 -->
					<div id="pd_add_right">
						<div id="pd_add_right_section">
							<h4>상품등록</h4>
						</div>
						<div class="pd_add_table_div">
							<form action="product_addAction.pd" name="ad_pd_add" method="post" enctype="multipart/form-data">
			                    <table>  
			                    	<tr>
			                            <th>상품번호</th>
			                            <td></td>
			                        </tr>                      
			                        <tr>
			                            <th>상품명</th>
			                            <td>
			                                <input type="text" name="pd_name" id="pd_add_name" autofocus required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>상품이미지1</th>
			                            <td colspan="2">
											<input type="file" name="pd_img1" id="pd_add_file1" accept="image/*" required>
										</td>
			                        </tr>
			                         <tr>
			                            <th>상품이미지2</th>
			                            <td colspan="2">
											<input type="file" name="pd_img2" id="pd_add_file2" accept="image/*" required>
										</td>
			                        </tr>
			                        <tr>
			                            <th>상품상세이미지</th>
			                            <td colspan="2">
											<input type="file" name="pd_detail_img" id="pd_add_defile" accept="image/*" required>
										</td>
			                        </tr>
			                        <tr>
			                            <th>판매가격</th>
			                            <td>
			                                <input type="text" name="pd_price" id="pd_add_price" required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>재고</th>
			                            <td>
			                                <input type="text" name="pd_stuck" id="pd_add_cnt" required>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>카테고리</th>
			                            <td>
			                                <select id="category_num" name="category_num">
												<option value="category" selected>카테고리 선택</option>
												<option value="Outer">Outer</option>
												<option value="Top">Top</option>
												<option value="Bottom">Bottom</option>
											</select>
			                            </td>
			                        </tr>
			                        <tr>
			                            <th>설명</th>
			                            <td colspan="2">
											<textarea rows="8" cols="70" name="pd_content" id="pd_add_ex"></textarea>
										</td>
			                        </tr>
			                        <tr>
			                            <td colspan="2">
			                                <input type="submit" value="등록" name="pd_add_btn" id="pd_add_btn">
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