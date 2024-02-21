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
<link rel="stylesheet" href="${path}/resources/css/customer/board_review.css" />
<script>
$(function(){
	// 게시판 목록
	$('#btnInsert').click(function(){
		location.href="${path}/board_reviewList.rw";		
	});
	
	// 게시판 수정
	$('#btnUpdate').click(function(){
		location.href="${path}/review_Edit.rw?hidden_num=${dto.review_num}";
	});	
	
	// 게시판 삭제
	$('#btnDelete').click(function(){
		if(confirm("정말 삭제하시겠습니까?")) {
			location.href="${path}/review_deleteAction.rw?hidden_num=${dto.review_num}";
	    }
	});		
});
</script>
</head>
<body>
	<div class="wrap">
		<!-- header 시작 -->
		<div id="header"><%@include file="/WEB-INF/views/common/header.jsp" %></div>
		<!-- header 끝 -->
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="contents">
			
				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<p align="center"> Review </p>
				</div>
				
				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="ad_productList" method="post"> <!-- 화면에서 입력받은 값을 전송한다. -->
								<table>
									<tr>
										<td class="board-title"> ${dto.review_title} </td> <!-- 제목 -->
									</tr>
									<tr>
										<td class="board-date">  ${dto.user_id} |  ${dto.review_date} </td> <!-- 작성자 / 날짜 -->
									</tr>
									<tr>
										<td class="top-border" style="width: 100%"></td>
									</tr>
									<tr>
									    <th><img src="${dto.review_img}" style="padding-bottom: 40px; padding-top: 10px;"></th> <!-- 이미지 -->
									</tr>
									<tr>
										<td class="board-date">  ${dto.review_content} </td> <!-- 내용 -->

									</tr> <!-- 내용 -->
									<tr>
										<td> <br><br> </td>
									</tr>
									
									<tr>
										<td class="top-border" style="width: 100%">
									</tr>
									<%-- <c:if test="${sessionScope.sessionID != null}">  --%>
										<tr>
											<td colspan="15" align="center">
												<input type="hidden" name="hidden_num" value="${dto.review_num}">
												<input type="button" class="write-btn-2" value="수정" id="btnUpdate">
												<input type="button" class="write-btn-2" value="삭제" id="btnDelete">
												<input type="button" class="write-btn" value="목록" id="btnInsert">
											</td>
										</tr>
									<%-- </c:if> --%>
									<tr>
										<td class="bottom-border" style="width: 100%">
									</tr>
<!-- 									<tr>
										<td class="board-title"> 댓글목록 </td>
									</tr>
									<tr>
										<td class="board-date"> (주)위드아웃썸머 | 날짜 </td>
									</tr>
									<tr>
										<td class="board-title"> 안녕하세요 :)<br>

										받아보신 상품 마음에 드셨다니 정말 다행이에요 ! ㅎㅎ <br>
										앞으로도 더 예쁜 상품들 많이 보여드릴 수 있도록 하겠습니다.<br>
										소중한 후기 감사드려요 !<br>
										
										행복한 하루 보내세요 ~!<br>
										 </td>
									</tr> -->

								</table>
								
								<br><br>
		                        <!-- 댓글 목록 코드 -->
		                        <div id="commentList" align="center"></div>
		                        <br><br>
		                        
		                        <!-- 댓글 입력 코드 -->
		                       <!--  <table align="center" border="1">
		                        	<tr>
										<td class="bottom-top" style="width: 100%">
									</tr>
		                        	<tr>
		                        		<th style="width: 20px"> 댓글내용 </th>
		                        		<td style="width: 250px; text-align: center">
		                        			<textarea rows="2" cols="140" name="content" id="content" placeholder="내용 입력"></textarea> 
										</td>
										<th style="width:40px" rowspan="2" align="right">
											<center><input type="button" class="inputButton" value="작성" id="btnInsert"></center>
										</th>
		                        	</tr>
		                        </table>  -->
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
	<div id="footer"><%@ include file="/WEB-INF/views/common/footer.jsp" %></div>
	<!-- footer 끝 -->
</body>
</html>