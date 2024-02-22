package spring.mvc.basic_1team.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.basic_1team.service.OrderService;
import spring.mvc.basic_1team.service.OrderServiceImpl;

@Controller
public class OrderController  {
	private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
       
	@Autowired
	private OrderServiceImpl service;
	String viewPage = "";
	
	@RequestMapping("selectPdOrderBefore.od") //조회
	public String selectPdOrderBefore (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /selectPdOrderBefore.do >>>");
		
		service.selectPdOrderBefore(req, model);
		return "customer/order/select_Pdpayment";
	}

	// 선택 결제 처리페이지  (수정)	
	@RequestMapping("selectPdOrderPayment.od") //조회
	public String selectPdOrderPayment (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /selectPdOrderPayment.do >>>");
		
		service.selectPdOrderPayment(req, model);
		return "customer/order/select_PdpaymentAction";
	}	
	
		
	// 전체 상품 주문결제 페이지 (전체조회)
	@RequestMapping("allPdOrderBefore.od") //조회
	public String allPdOrderBefore (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /selectPdOrderPayment.do >>>");
		
		service.allPdOrderBefore(req, model);
		return "customer/order/all_Pdpayment";
	}		
		
	
	// 전체 결제 처리페이지 (수정)
	@RequestMapping("allPdOrderPayment.od") //조회
	public String allPdOrderPayment (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /selectPdOrderPayment.do >>>");
		
		service.allPdOrderPayment(req, model);
		return "customer/order/all_PdpaymentAction";
	}			
	
}
