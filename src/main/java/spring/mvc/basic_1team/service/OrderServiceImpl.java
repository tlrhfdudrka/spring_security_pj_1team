package spring.mvc.basic_1team.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spring.mvc.basic_1team.dao.OrderDAOImpl;
import spring.mvc.basic_1team.dto.CustomerDTO;
import spring.mvc.basic_1team.dto.OrderDTO;

public class OrderServiceImpl implements OrderService{

	// 선택 상품 주문결제 페이지
	@Override
	public void selectPdOrderBefore(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - selectPdOrderBefore(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		List<OrderDTO> list = dao.selectPdList(user_id);
		int selectpdPrice = dao.orderTotalPrice1(user_id);
		CustomerDTO c_dto = dao.userInfo(user_id);
		
		req.setAttribute("list", list);
		req.setAttribute("selectpdPrice", selectpdPrice);
		req.setAttribute("c_dto", c_dto);
		
	}
	
	// 선택 결제 처리 
	@Override
	public void selectPdOrderPayment(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - selectPdOrderPayment(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		int updateCnt = dao.isPaymentUpdate1(user_id);
	
		req.setAttribute("updateCnt", updateCnt);
		
	}

	// 전체 상품 주문결제 페이지
	@Override
	public void allPdOrderBefore(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		System.out.println("<< 서비스 - allPdOrderBefore(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		List<OrderDTO> list = dao.allPdList(user_id);
		int selectpdPrice = dao.orderTotalPrice2(user_id);
		CustomerDTO c_dto = dao.userInfo(user_id);
		
		req.setAttribute("list", list);
		req.setAttribute("selectpdPrice", selectpdPrice);
		req.setAttribute("c_dto", c_dto);
	}	
	
	// 전체 결제 처리 
	@Override
	public void allPdOrderPayment(HttpServletRequest req, HttpServletResponse res)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - allPdOrderPayment(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		int updateCnt = dao.isPaymentUpdate2(user_id);
		
		req.setAttribute("updateCnt", updateCnt);
	
	}
}
