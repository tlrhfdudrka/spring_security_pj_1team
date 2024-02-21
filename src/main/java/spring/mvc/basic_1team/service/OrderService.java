package spring.mvc.basic_1team.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface OrderService {

	// 선택 상품 주문결제 페이지
	public void selectPdOrderBefore(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 선택 결제 처리
	public void selectPdOrderPayment(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;
	
	// 전체 상품 주문결제 페이지
	public void allPdOrderBefore(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException;

	// 전체 결제 처리
	public void allPdOrderPayment(HttpServletRequest req, HttpServletResponse res)
	throws ServletException, IOException;

}
