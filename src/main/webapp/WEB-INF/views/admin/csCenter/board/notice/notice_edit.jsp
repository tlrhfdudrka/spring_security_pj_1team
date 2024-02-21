<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice - 글수정</title>
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
<link rel="stylesheet" href="${path}/resources/css/admin/notice_edit.css" />
<script>
	 $(function(){ // 작성 페이지가 로딩되면
		
		// 게시글 목록버튼 클릭시 컨트롤러의 목록으로 이동
		$("#btnList").click(function() {
			location.href="${path}/noticeList.nt"; // 단순 페이지 이동시에는 location
		});
	 
		$('#btnEdit').click(function(){
			
			const notice_title = $("#notice_title").val();
			const notice_content = $("#notice_content").val();			
			const notice_pwd = $("#notice_pwd").val();

			if(notice_title == ""){
				alert("제목을 입력하세요");
				$("#notice_title").focus();
				return false;
			}
			if(notice_content == ""){
				alert("내용을 입력하세요");
				$("#notice_content").focus();
				return false;
			}
			/* if(notice_pwd == ""){
				alert("비밀번호를 입력하세요");
				$("#notice_pwd").focus();
				return false;
			} */
			
			document.notice_editForm.action="${path}/notice_updateAction.nt";
			document.notice_editForm.submit();
			
		});
		
	}); 
</script>
</head>
<body>

	<!-- header 시작 -->
	<div id="header"><%@include file="/WEB-INF/views/common/header.jsp" %></div>
	<!-- header 끝 -->
	<div class="wrap">
		<!-- 컨텐츠 시작 -->
		<div class="container">
			<div class="contents">

				<!-- 상단 중앙1 시작 -->
				<div id="section1">
					<p align="center">Notice</p>
				</div>

				<!-- 상단 중앙2 시작 -->
				<div id="section2">
				
					<!-- 내용 시작 -->
					<div id="right">
						<div class="table_div">
							<form name="notice_editForm" method="post">
								<!-- 화면에서 입력받은 값을 전송한다. -->
		                       <table>
		                           <tr>
		                               <th id="titleLabel" style="width: 60px">글제목</th>
		                               <td colspan="3" style="width: 750px">
		                                  <input style="width: 670px" type="text" class="input" name="notice_title"
		                                    id="notice_title" size="50" value="${dto.notice_title}">
		                               </td>
		                           </tr>
		                           
		                           <tr>   
		                               <th id="contentLabel" style="width: 60px">글내용</th>
		                               <td colspan="3">
		                                  <textarea rows="5" cols="93" name="notice_content" 
		                                  	id="notice_content">${dto.notice_content}</textarea>
		                               </td>
		                           </tr>
									<tr>
										<td colspan="5" align="center">
											<input type="hidden" name="notice_num" value="${dto.notice_num}">
											<input type="button" class="write-btn" value="목록" id="btnList">
											<input type="button" class="write-btn" value="수정" id="btnEdit">
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
	<div id="footer"><%@ include file="/WEB-INF/views/common/footer.jsp" %></div>
	<!-- footer 끝 -->
</body>
</html>