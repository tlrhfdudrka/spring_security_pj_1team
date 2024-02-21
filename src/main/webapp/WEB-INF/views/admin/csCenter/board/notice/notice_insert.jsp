<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice - 글등록</title>
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
<link rel="stylesheet" href="${path}/resources/css/admin/notice_insert.css" />
<script>
	$(function(){ // 작성 페이지가 로딩되면
		
		// 게시글 작성버튼 클릭시 컨트롤러의 게시글 처리페이지로 이동
		$('#btnSave').click(function(){
			
			const user_id = $("#user_id").val();
			const notice_title = $("#notice_title").val();
			const notice_content = $("#notice_content").val();
			
			// 작성자
			if(user_id == ""){
				alert("아이디를 입력하세요");
				$("#user_id").focus();
				return false;
			}
			
			// 제목
			if(notice_title == ""){
				alert("제목을 입력하세요");
				$("#notice_title").focus();
				return false;
			}
			
			// 내용
			if(notice_content == ""){
				alert("내용을 입력하세요");
				$("#notice_contentt").focus();
				return false;
			}
			
			document.notice_insertForm.action="${path}/notice_insertAction.nt";
			document.notice_insertForm.submit();
			
		});
	});
	

    function handleTextarea() {
        var textarea = document.getElementById("notice_content");
        textarea.value = textarea.value.replace(/\n/g, "<br>");
    }

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
							<form name="notice_insertForm" method="post">
								<!-- 화면에서 입력받은 값을 전송한다. -->
		                       <table>
		                           <tr>
		                              <th id="writerLabel" style="width: 60px"> 아이디 </th>
		                              <td >
		                                 <input style="width: 200px" type="text" class="input" name="user_id" id="user_id" size="30" value="admin01" readonly>
		                              </td>
		                              
		                           </tr>
		                           
		                           <tr>
		                               <th id="titleLabel" style="width: 60px"> 글제목 </th>
		                               <td colspan="3" style="width: 750px">
		                                  <input style="width: 670px" type="text" class="input" name="notice_title"
		                                    id="notice_title" size="50" placeholder="글제목 입력" required autofocus>
		                               </td>
		                           </tr>
		                           
		                           <tr>   
		                               <th id="contentLabel" style="width: 60px"> 글내용 </th>
		                               <td colspan="3">
		                                  <textarea rows="5" cols="93" name="notice_content" id="notice_content" onchange="handleTextarea()"></textarea>
		                               </td>
		                           </tr>
									<tr>
										<td colspan="5" align="center">
											<input type="hidden" name="notice_num" value="${dto.notice_num}">
											<input type="reset" class="write-btn-w" value="초기화">
											<input type="button" class="write-btn" value="등록" id="btnSave">
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