<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="setting.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">

<!-- css -->
<link rel="stylesheet" href="${path}/resources/css/common/.css" />
<link rel="stylesheet" href="${path}/resources/css/common/.css" />

<title>main</title>
</head>
<body>

	<div id="header"><%@include file="/WEB-INF/views/common/header.jsp" %></div>
	<div class="wrap">
		<div class="main_visula">
			<video autoplay loop muted style="width: 100%;">
				<source src="https://player.vimeo.com/progressive_redirect/playback/889803908/rendition/1080p/file.mp4?loc=external&signature=6b8c8fa8458013e78950fb40990934e67a0a477c9fb27d050d7bef7e7b470029" type="video/mp4">
			</video>
		</div>
	</div>


</body>
</html>