<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/WEB-INF/views/common/setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
<link rel="stylesheet" href="${path}/resources/css/customer/board_insert.css" />
<script>
	$(function(){ // 작성 페이지가 로딩되면
		
		
		$('#btnSave').click(function(){
			
			const password = $("#password").val();
			const title = $("#title").val();
			const content = $("#content").val();
			 
			if(title == ""){
				alert("제목을 입력하세요!!");
				$("#title").focus();
				return false;
			}
			if(content == ""){
				alert("내용을 입력하세요!!");
				$("#content").focus();
				return false;
			}
			
			document.editForm.action="${path}/board_reviewEdit.rw";
			document.editForm.submit();
			
		});
	});
</script>
</head>
<body>

	<!-- header 시작 -->
	<div id="header"><%@include file="/WEB-INF/views/common/header.jsp"%></div>
	<!-- header 끝 -->
	<div class="wrap">
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="contents">

				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<p align="center">Review</p>
				</div>

				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="editForm" method="post"  enctype="multipart/form-data">
								<!-- 화면에서 입력받은 값을 전송한다. -->
		                       <table>
		                         <!--   <tr>
		                              <th style="width: 100px"> 작성자 </th>
		                              <td >
		                                 <input style="width: 200px" type="text" class="input" name="writer"
		                                    id="writer" size="30" placeholder="작성자 입력" required autofocus>
		                              </td>
		                              
		                           </tr> -->
		                           
		                           <tr>
		                               <th style="width: 100px">글제목</th>
		                               <td colspan="3" style="width: 750px">
		                                  <input style="width: 670px" type="text" class="input" name="review_title"
		                                    id="title" size="50" placeholder="글제목 입력"  value="${dto.review_title}" required>
		                               </td>
		                           </tr>
		                           
		                           <tr>   
		                               <th style="width: 100px">글내용</th>
		                               <td colspan="3">
		                                  <textarea rows="5" cols="93" name="review_content" id="content">${dto.review_content}</textarea>
		                               </td>
		                           </tr>
		                           <tr>
			                            <th>첨부파일</th>
			                            <td colspan="2">
											<input type="file" name="review_img" id="pd_file" style="width: 100%;" value="파일첨부" accept="image/*">
										</td>
			                        </tr>
		                           <tr>
		                        <!--     <th style="width: 100px" > 비밀번호 </th>
		                              <td style="width: 200px">
		                                 <input style="width: 200px" type="password" class="input" name="password"
		                                    id="password" size="30" placeholder="비밀번호 입력" required>
		                              </td>
		                           </tr>  -->
									<tr>
										<td colspan="5" align="center">
											<input type="hidden" name="hidden_num" value="${dto.review_num}">
											<input type="hidden" name="hidden_img" value="${dto.review_img}">
											<input type="reset" class="write-btn-w" value="초기화">
											<input type="button" class="write-btn" value="수정" id="btnSave">
										</td>
									</tr>
								</table>
							</form>
						</div>
					</div>
					<!-- 내용 종료 -->
				</div>
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
	</div>

	<!-- footer 시작 -->
	<div id="footer"><%@include file="/WEB-INF/views/common/footer.jsp"%></div>
	<!-- footer 끝 -->
	<script src="${path}/header/header.js"></script>
</body>
</html>