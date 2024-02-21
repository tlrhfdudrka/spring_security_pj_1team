<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>notice - 글목록</title>
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
<link rel="stylesheet" href="${path}/resources/css/admin/noticeList.css" />

<script src="https://kit.fontawesome.com/67a1f076db.js" crossorigin="anonymous"></script>
<script>
	$(function() {
		$("#btnInsert").click(function() {
			location.href="${path}/notice_insert.nt";
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
							<form name="ad_noticeList" method="post">
								<!-- 화면에서 입력받은 값을 전송한다. -->
								<table>
									<!-- 게시글이 있으면 -->
									<!-- forEach 태그는 배열, ArrayList, Map에 저장되어 있는 값들을 순차적으로 처리할 때 사용한다. -->
									<c:forEach var="dto" items="${list}">
										<tr>
											<td class="top-border" style="width: 100%">
										</tr>
										<tr>
											<td class="notice-title" style="width: 100%">
											<a href="${path}/notice_detailAction.nt?notice_num=${dto.notice_num}">${dto.notice_title}</a></td>
										</tr>

										<tr>
											<td class="notice-date"> (주)위드아웃썸머 | ${dto.notice_date} | 조회 ${dto.notice_readCnt} </td>
										</tr>
										<tr>
											<td class="bottom-border"></td>
										</tr>
									</c:forEach>
									<tr>
									 	<%-- <c:if test="${sessionScope.sessionID == 'admin01'}"> --%>  <!-- 세션이 있는 경우 : 로그인 상태 -->
											<td colspan="5" align="center"><input type="button"
												class="write-btn" value="글작성" id="btnInsert"></td>
										<%-- </c:if>	 --%>
									</tr>
									
									<tr>
										<td class="paging" colspan="5" align="center">
											
											<!-- 페이징 처리 -->
			                                 <!-- 이전 버튼 활성화 -->
			                                 <c:if test="${paging.startPage > 0}">
			                                    <a href="${path}/noticeList.nt?pageNum=${paging.prev}"><i class="fa-solid fa-angle-left"></i></a>
			                                 </c:if>
			                                 
			                                 <!-- 페이지 번호 처리 -->
			                                 <c:forEach var="num" begin="${paging.startPage}" end="${paging.endPage}">
			                                    <a href="${path}/noticeList.nt?pageNum=${num}">${num}</a>
			                                 </c:forEach>
			                                 
			                                 <!-- 다음 버튼 활성화 -->
			                                 <c:if test="${paging.endPage < paging.pageCount}">
			                                    <a href="${path}/noticeList.nt?pageNum=${paging.next}"><i class="fa-solid fa-angle-right"></i></a>
			                                 </c:if>
			                                 <!-- 페이징 처리 끝 -->
											
										</td>
									</tr>
								</table>
							</form>

							<div class="board-search">
								<div class="select-box">
									<select value="게시판선택" class="time-select">
										<option selected disabled>일주일</option>
										<option value="board">한달</option>
										<option value="board">세달</option>
										<option value="board">전체</option>
									</select>
									<select value="게시판선택" class="title-select">
										<option selected disabled>제목</option>
										<option value="board">내용</option>
										<option value="board">글쓴이</option>
										<option value="board">아이디</option>
										<option value="board">별명</option>
									</select>
								</div>
							<div class="search-wrap">
								<!-- 아이디 세션값 가져오기 -->
								<input type="hidden" name="hidden_Id" value="${sessionID}">
								<td><input type="search" class="search-box"></td>
								<td><input type="submit" class="search-btn" value="검색"></td>
							</div>	
							</div>
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