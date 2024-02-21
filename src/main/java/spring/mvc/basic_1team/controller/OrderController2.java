package spring.mvc.basic_1team.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import spring.mvc.basic_1team.service.OrderService;
import spring.mvc.basic_1team.service.OrderServiceImpl;

@WebServlet("*.od")
public class OrderController2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public OrderController2() {
        super();
    }

	protected void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		action(req, res);
	}

	protected void doPost(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		doGet(req, res);
	}

	public void action(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException {
		
		// 2단계. 클라이언트 요청 분석
		
		// 한글 안깨지게 처리
		req.setCharacterEncoding("UTF-8");
		
		String viewPage = "";  // 보여질 페이지의 경로를 담을 변수 선언
		
		OrderService service = new OrderServiceImpl();
		
		// 우리가 필요한 url만 가져오기 위한 편집 과정
		String uri = req.getRequestURI(); // URI : contextPath(/플젝명)부터 끝까지의 url
		String contextPath = req.getContextPath();  // ContextPath : /플젝명
		String url = uri.substring(contextPath.length());
		
		// 본격 클라이언트 요청 분석 시작
		// 선택 상품 주문결제 페이지
		if(url.equals("/selectPdOrderBefore.od")) {
			System.out.println("<< 컨트롤러 url - /selectPdOrderBefore.od >>");
			
			service.selectPdOrderBefore(req, res);
			
			viewPage = "customer/order/select_Pdpayment.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
		
		// 선택 결제 처리페이지 
		else if(url.equals("/selectPdOrderPayment.od")) {
			System.out.println("<< 컨트롤러 url - /selectPdOrderPayment.od >>");
			
			service.selectPdOrderPayment(req, res);
			
			viewPage = "customer/order/select_PdpaymentAction.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
		
		// 전체 상품 주문결제 페이지
		else if(url.equals("/allPdOrderBefore.od")) {
			System.out.println("<< 컨트롤러 url - /allPdOrderBefore.od >>");
			
			service.allPdOrderBefore(req, res);
			
			viewPage = "customer/order/all_Pdpayment.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
		
		// 전체 결제 처리페이지 
		else if(url.equals("/allPdOrderPayment.od")) {
			System.out.println("<< 컨트롤러 url - /allPdOrderPayment.od >>");
			
			service.allPdOrderPayment(req, res);
			
			viewPage = "customer/order/all_PdpaymentAction.jsp";
			RequestDispatcher dispatcher = req.getRequestDispatcher(viewPage);
			dispatcher.forward(req, res);
		}
		
	}	
}
