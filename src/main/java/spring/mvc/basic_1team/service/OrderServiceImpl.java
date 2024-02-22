package spring.mvc.basic_1team.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.basic_1team.dao.OrderDAO;
import spring.mvc.basic_1team.dao.OrderDAOImpl;
import spring.mvc.basic_1team.dto.CustomerDTO;
import spring.mvc.basic_1team.dto.OrderDTO;

@Service
public class OrderServiceImpl implements OrderService{

	@Autowired
	private OrderDAO dao;
	
	// 선택 상품 주문결제 페이지 (조회)
	@Override
	public void selectPdOrderBefore(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - selectPdOrderBefore(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		//OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		List<OrderDTO> list = dao.selectPdList(user_id);
		int selectpdPrice = dao.orderTotalPrice1(user_id);
		CustomerDTO c_dto = dao.userInfo(user_id);
		
		model.addAttribute("list", list);
		model.addAttribute("selectpdPrice", selectpdPrice);
		model.addAttribute("c_dto", c_dto);
		
	}
	
	// 선택 결제 처리  (수정)
	@Override
	public void selectPdOrderPayment(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - selectPdOrderPayment(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		//OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		int updateCnt = dao.isPaymentUpdate1(user_id);
	
		model.addAttribute("updateCnt", updateCnt);
		
	}

	// 전체 상품 주문결제 페이지 (전체조회)
	@Override
	public void allPdOrderBefore(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - allPdOrderBefore(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		//OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		List<OrderDTO> list = dao.allPdList(user_id);
		int selectpdPrice = dao.orderTotalPrice2(user_id);
		CustomerDTO c_dto = dao.userInfo(user_id);
		
		model.addAttribute("list", list);
		model.addAttribute("selectpdPrice", selectpdPrice);
		model.addAttribute("c_dto", c_dto);
	}	
	
	// 전체 결제 처리 (수정)
	@Override
	public void allPdOrderPayment(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("<< 서비스 - allPdOrderPayment(req, res) >>");
		
		String user_id = (String)req.getSession().getAttribute("sessionID");
		
		//OrderDAOImpl dao = OrderDAOImpl.getInstance();
		
		int updateCnt = dao.isPaymentUpdate2(user_id);
		
		model.addAttribute("updateCnt", updateCnt);
	
	}
}
