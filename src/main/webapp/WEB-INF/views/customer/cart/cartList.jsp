<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니목록</title>
<link rel="stylesheet" href="${path}/resources/css/common/header.css">
<link rel="stylesheet" href="${path}/resources/css/common/footer.css">
<link rel="stylesheet" href="${path}/resources/css/customer/cartList.css">
<script src="${path}/header/header.js" defer></script>
<script type="text/javascript">

/*let cart_cnt = 1;*/

/* 화면 수량 변경(증가/감소) 및 장바구니 상품 수량 수정 */
function count(type, index) {
	let pd_count = document.getElementsByClassName("pd_count")[index];
	let cart_cnt = parseInt(pd_count.innerText);
	
	let hidden_cart_num = document.getElementsByName("hidden_cart_num")[index].value;
	
	if(type == "minus") {
		cart_cnt -= 1
		if(cart_cnt == 0) return;
	}
	else if(type == "plus") {
		cart_cnt += 1
	}
	
	pd_count.innerText = cart_cnt;
	/*cart_cnt = count;*/
	
	document.cartList.action="${path}/cart_pdUdateAction.ct?hidden_cart_num=" + hidden_cart_num + "&cart_cnt=" + cart_cnt;
	document.cartList.submit();
}


/* 장바구니 상품 삭제시 */
function del_comfirm(index) {
	if(confirm("삭제하시겠습니까?")){
		let hidden_cart_num = document.getElementsByName("hidden_cart_num")[index].value;
		document.cartList.action = "${path}/cart_pdDeleteAction.ct?hidden_cart_num=" + hidden_cart_num;
		document.cartList.submit();
	}
}


/* 장바구니 상품 체크박스 선택 여부에 따른 컨트롤러 진입  */
function ischkbox(index) {
	
	let hidden_cart_num = document.getElementsByName("hidden_cart_num")[index].value;
	
	if(document.getElementsByName("checkbox")[index].checked) {
		document.cartList.action="${path}/cart_checkedAction.ct?hidden_cart_num=" + hidden_cart_num;
		document.cartList.submit();
	}
	else {
		document.cartList.action="${path}/cart_notCheckedAction.ct?hidden_cart_num=" + hidden_cart_num;
		document.cartList.submit();
	}
	
}

/* select order 버튼 클릭시 */
function select_ord() {
	let checks = document.getElementsByName("hidden_NotchkConfirm");
	let values = [];
	
	for(let i=0; i<checks.length; i++) {
		values.push(checks[i].value);
	}
	
	if(values.every(value => value === "y")) {
		alert("선택한 상품이 없습니다.");
	}
	else {
		document.cartList.action="${path}/selectPdOrderBefore.od?user_id=${sessionScope.sessionId}";
		document.cartList.submit();
	}

}

/* all order 버튼 클릭시 */
function all_ord() {
	
	if(confirm("모든 상품을 구매하시겠습니까?")) {
		document.cartList.action="${path}/allPdOrderBefore.od?user_id=${sessionScope.sessionId}";
		document.cartList.submit();
	}
	
}

</script>
</head>
<body>

	<div class="all_wrap">
		<!-- header 시작 -->
		<%@include file="/WEB-INF/views/common/header.jsp" %>
		<!-- header 끝 --> 
		 
		<!-- 컨텐츠 시작 -->
		<div class="cart_wrap">
			<div id="cart_container">
				<form name="cartList" method="post">
					<table class="cartList_tb">
						<!-- 장바구니 목록 시작 -->
						<c:forEach var="dto" items="${list}" varStatus="loop">
							<%-- <input type="hidden" name="hidden_user_id" value="${dto.user_id}"> --%>
							<tr class="cartList_detail">
							<!-- 체크박스 -->
	                        <td class="cart_checkbox">
	                        	<c:if test="${dto.is_chkbox.equals('y')}">
	                        		<input type="checkbox" name="checkbox" class="cartchkbox" onclick="ischkbox(${loop.index})">
	                        	</c:if>
	                        	<c:if test="${dto.is_chkbox.equals('n')}">
	                        		<input type="checkbox" name="checkbox" class="cartchkbox" onclick="ischkbox(${loop.index})" checked>
	                        	</c:if>
	                        	<input type="hidden" name="hidden_NotchkConfirm" value="${dto.is_chkbox}">
	                        </td>
	                        
	                        <!-- 장바구니에 담은 상품 사진 -->
	                        <td class="cart_pd_photo">
	                        	<img class="pd_img" src="${dto.ct_pdimg}">
	                        </td>
	                        
	                        <!-- 상품명 및 간단한 배송정보 및 증가/감소 상품 수량 선택 -->
	                        <td class="cart_pd_name">
	                        	<a href="#" class="cart_pd_name_a">${dto.ct_pdname}</a>
	                            <p class="cart_pd_name_p">배송 : [무료] / 기본배송</p>
	                            
	                            <!-- 증가/감소 상품 수량 선택 -->
	                            <div class="cart_pdcount_choice">
		                            <input type="button" name="minus" value="-" class="minus" onclick="count('minus', ${loop.index})">
	                        		<span class="pd_count">${dto.cart_cnt}</span>
	                        		<input type="button" name="plus" value="+" class="plus" onclick="count('plus', ${loop.index})">
	                        	</div>
	                        </td>
	                        
	                        <!-- 상품 가격 -->
	                        <td class="cart_pd_price">
	                        	<p class="cart_pd_price_p">${dto.ct_pdprice}원</p>
	                        </td>
	                        
	                        <!-- 빈 열 추가 -->
	                        <td class="cart_pd_option"></td>
	                        
	                        <!-- 삭제 버튼 -->
	                        <td class="cart_pd_delete">
	                        	<input type="button" name="delete_btn" value="삭제" id="btnDelete" class="delete_btn" onclick="del_comfirm(${loop.index})">
	                        	<input type="hidden" name="hidden_cart_num" value="${dto.cart_num}">
	                        </td>
	                    	</tr>
						</c:forEach>
	                    <!-- 장바구니 목록 끝 -->
	                    
	                    <!-- 총주문금액 및 주문 버튼 -->
	                    <tr id="totalPrice_order">
	                    	<td colspan="4" id="totalPrice_order_td1"></td>
	                    	<td id="totalPrice_order_td2">
	                    		<p class="totalPrice_order_p"><span class="totalPrice_order_span">PRODUCT</span></p>
	                    		<p class="totalPrice_order_p"><span class="totalPrice_order_span">SHIPPING</span></p>
	                    		<p class="totalPrice_order_p"><span class="totalPrice_order_span">TOTAL</span></p>
	                    		<input type="button" name="select_order" id="select_order_btn" value="SELECT ORDER" onclick="select_ord()">
	                    	</td>
	                    	
	                    	<td id="totalPrice_order_td3">
	                    		<p class="totalPrice_order_p">${totalPrice}원</p>
	                    		<p class="totalPrice_order_p">${selectpdPrice}원</p>
	                    		<p class="totalPrice_order_p">${selectpdPrice}원</p>
	                    		<input type="button" name="all_order" id="all_order_btn" value="ALL ORDER" onclick="all_ord()">
	                    	</td>
	                    </tr>
	                    <!-- 로그인 세션 값 가져오기 -->
	                    <%-- <input type="hidden" name="hidden_s_user_id" value="${sessionScope.sessionId}"> --%>
					</table>
				</form>
			</div>
		</div>
		<!-- 컨텐츠 끝 -->
		
		<!-- footer 시작 -->
		<%@ include file="/WEB-INF/views/common/footer.jsp" %>
		<!-- footer 끝 -->
	</div>
</body>
</html>