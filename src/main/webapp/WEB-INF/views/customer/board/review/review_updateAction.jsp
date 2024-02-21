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
<link rel="stylesheet" href="${path}/resources/css/admin/board_insert.css" />
<script>

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
					<p align="center">Notice</p>
				</div>

				<!-- 상단 중앙2 시작 -->
				<div id="section2">
					<!-- 내용 시작 -->
					  <c:if test="${updateCnt == 1}">
                  <script type="text/javascript">
                     setTimeout(function() {
                        alert("상품수정 성공!!");
                        window.location="${path}/board_reviewList.rw?pageNum=${hiddenPageNum}";
                     }, 1000);
                  </script>
               </c:if>   
               
               <c:if test="${updateCnt != 1}">
                  <script type="text/javascript">
                     setTimeout(function() {
                        alert("상품등록 실패");
                        window.location="${path}/review_Edit.rw?pdNo=${hiddenPdNo}&pageNum=${hiddenPageNum}";
                     }, 1000);
                  </script>
               </c:if>
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