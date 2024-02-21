<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file= "/WEB-INF/views/common/setting.jsp"%>    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>선택 상품 주문결제</title>
<link rel="stylesheet" href="${path}/resources/css/common/header.css" />
<link rel="stylesheet" href="${path}/resources/css/common/footer.css" />
<link rel="stylesheet" href="${path}/resources/css/customer/payment.css">
<script type="text/javascript">
function delivery_input_chk() {
	
	/* 받는 사람 입력 확인 */
	if(!document.paymentform.recipient.value) {
		alert("받는 사람을 입력하세요.");
		document.paymentform.recipient.focus();
		return false;
	}
	
	/* 주소 입력 확인 */
	if(!document.paymentform.address.value) {
		alert("주소를 입력하세요");
		document.paymentform.address.focus();
		return false;
	}
	
	/* 휴대전화 입력 확인 */
	if(!document.paymentform.phNum.value) {
		alert("휴대전화를 입력하세요");
		document.paymentform.phNum.focus();
		return false;
	}
	
	/* 입금은행 입력 확인 */
	if(!document.paymentform.bank_choice.value) {
		alert("입금 은행을 선택해주세요.");
		return false;
	}
	
	/* 입금자명 입력 확인 */
	if(!document.paymentform.depositor.value) {
		alert("입금자명을 입력해주세요.");
		document.paymentform.depositor.focus();
		return false;
	}
	
	/* 동의 체크박스 필수 체크 */
	if(!document.paymentform.agree_chkbox.checked) {
		alert("약관에 동의해주세요.");
		return false;
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
		<div class="payment_wrap">
			<div id="payment_container">
				<form name="paymentform" method="post" action="${path}/selectPdOrderPayment.od" onsubmit="return delivery_input_chk()">
					<!-- 배송지  -->
					<div id="delivery_address" class="div">
							<p class="p_tag">배송지</p>
							<table id="delivery_address_tb" class="table">
								<tr>
									<td class="delivery_address_td1">받는 사람*</td>
									<td class="delivery_address_td2">
										<input type="text" name="recipient" id="recipient" class="input" value="${c_dto.user_name}">
									</td>
								</tr>
								
								<tr>
									<td class="delivery_address_td1">주소*</td>
									<td class="delivery_address_td2">
										<input type="text" name="address" id="address" class="input" value="${c_dto.user_address}">
									</td>
								</tr>
								
								<tr>
									<td class="delivery_address_td1">휴대전화*</td>
									<td class="delivery_address_td2">
										<input type="text" name="phNum" id="phNum" class="input" placeholder="ex)  010-1111-2222" value="${c_dto.user_hp}">
									</td>
								</tr>
							</table>				
						
					</div>
					<!-- 배송지 끝 -->
					
					<!-- 주문상품 -->
					<div id="order_pd" class="div">
						<p class="p_tag">주문상품</p>
						<table id="order_pd_tb" class="table">
							<c:forEach var="dto" items="${list}">
								<tr>
								<td class="order_pd_td1">
									<img class="pd_img" src="${dto.ct_pdimg}">
								</td>
								<td class="order_pd_td2">
									<p class="order_pd_td2_p1">${dto.ct_pdname}</p>
									<p class="order_pd_td2_p2">수량: ${dto.cart_cnt}개</p>
									<p class="order_pd_td2_p3">${dto.ct_pdprice}원</p>
								</td>
							</tr>
							</c:forEach>
							
							<tr>
								<td colspan="2"> 
								</td>
							</tr>
						</table>
					</div>
					<!-- 주문상품 끝 -->
					
					<!-- 결제수단 -->
					<div id="payment_method" class="div">
						<p class="p_tag">결제수단</p>
						<div id="method_div">
							<p class="method_p">무통장입금</p>
							<table id="method_tb" class="table">
								<tr>
									<td class="method_td2">입금은행*</td>
									<td class="method_td3">
										<select class="method_select" name="bank_choice">
											<option value="">::: 선택해주세요 :::</option>
											<option value="기업은행 11122223333111">기업은행 11122223333111 (주)위드아웃썸머</option>
										</select>
									</td>
								</tr>
								
								<tr>
									<td class="method_td2"><p>입금자명*</p></td>
									<td class="method_td3">
										<input type="text" name="depositor" id="depositor" class="input" value="${c_dto.user_name}">
									</td>
								</tr>
							</table>
						</div>
					</div>	
					<!-- 결제수단 끝 -->
					
					<!-- 결제정보 -->
					<div id="paymentInfo" class="div">					
						<p class="p_tag">결제정보</p>
						<table class="table">
							<tr>
								<td class="paymentInfo_td1">
									<p class="paymentInfo_p1">주문 상품</p>
									<p class="paymentInfo_p1">배송비</p>
									<p class="paymentInfo_p2">최종 결제 금액</p>
								</td>
								
								<td class="paymentInfo_td2">
									<p class="paymentInfo_p3">${selectpdPrice}원</p>
									<p class="paymentInfo_p3">무료</p>
									<p class="paymentInfo_p4">${selectpdPrice}원</p>
								</td>
							</tr>
						</table>
					</div>	
					<!-- 결제정보 끝 -->
					
					<!-- 결제버튼 및 동의문구 -->
					<div id="agree_payment" class="div">
						<table>
							<tr>
								<td>
									<p class="agree_p1">구매조건 확인 및 결제 진행 동의</p>
									<p class="agree_p2">
										<input type="checkbox" name="agree_chkbox" class="agree_chk" id="agree_chkbox">
										<span class="agree_span">주문 내용을 확인하였으며 약관에 동의합니다.</span>
									</p>
								</td>
							</tr>
							
							<tr>
								<td id="agree_payment_td2">
									<input type="submit" name="payment_btn" value="결제하기" id="payment_btn">
								</td>
							</tr>
							
						</table>
					</div>
					<!-- 결제버튼 및 동의문구 끝 -->
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