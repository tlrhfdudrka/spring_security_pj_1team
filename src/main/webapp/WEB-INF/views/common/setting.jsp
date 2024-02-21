<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	
<!-- jstl -->
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!-- 컨텍스트패스 즉 플젝명( mvc_jsp_shopping )을 path에 설정 -->
<c:set var="path" value="${pageContext.request.contextPath}"/>
<!-- path라는 변수에 플젝명 jsp_pj_ict02을 주겠다. ${pageContext.request.contextPath} -> 플젝명-->
<script type="text/javascript"  src="http://code.jquery.com/jquery-3.7.1.min.js" ></script>  <!--  따로 닫는다. -->