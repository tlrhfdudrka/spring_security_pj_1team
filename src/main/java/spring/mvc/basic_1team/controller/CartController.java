package spring.mvc.basic_1team.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.basic_1team.service.CartServiceImpl;

@Controller
public class CartController {

	@Autowired
	private CartServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(CartController.class);
	
	// ========== 장바구니 목록 페이지 ==========
	@RequestMapping("cartList.ct")
	public String cartList(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cartList.ct ===");
		
		service.cartPdListAction(req, res, model);
		
		return "customer/cart/cartList";
	}
	
	// ========== 장바구니 상품 삭제 ==========
	@RequestMapping("cart_pdDeleteAction.ct")
	public String cart_pdDeleteAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cart_pdDeleteAction.ct ===");
		
		service.cartPdDeleteAction(req, res, model);
		
		return "redirect:/";
	}
	
	// ========== 장바구니 상품 수량 수정 ==========
	@RequestMapping("cart_pdUdateAction.ct")
	public String cart_pdUdateAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cart_pdUdateAction.ct ===");
		
		service.cartPdUpdateAction(req, res, model);
		
		return "redirect:/";
	}
	
	// ========== 장바구니 상품 체크박스 선택시 ==========
	@RequestMapping("cart_checkedAction.ct")
	public String cart_checkedAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cart_checkedAction.ct ===");
		
		service.cartPdCheckedAction(req, res, model);
		
		return "redirect:/";
	}
	
	// ========== 장바구니 상품 체크박스 비선택시 ==========
	@RequestMapping("cart_notCheckedAction.ct")
	public String cart_notCheckedAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cart_notCheckedAction.ct ===");
		
		service.cartPdNotCheckedAction(req, res, model);
		
		return "redirect:/";
	}
	
	// ========== 장바구니 상품 추가시 중복확인(bottom) ==========
	@RequestMapping("cart_pdchk_bottom.ct")
	public String cart_pdchk_bottom(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cart_pdchk_bottom.ct ===");
		
		service.cart_pdchk_bottom(req, res, model);
		
		return "customer/cart/cart_pdchkAction_bottom";
	}
	
	// ========== 장바구니 상품 추가시 중복확인(outer) ==========
	@RequestMapping("cart_pdchk_outer.ct")
	public String cart_pdchk_outer(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cart_pdchk_outer.ct ===");
		
		service.cart_pdchk_outer(req, res, model);
		
		return "customer/cart/cart_pdchkAction_outer";
	}
	
	// ========== 장바구니 상품 추가시 중복확인(top) ==========
	@RequestMapping("cart_pdchk_top.ct")
	public String cart_pdchk_top(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cart_pdchk_top.ct ===");
		
		service.cart_pdchk_top(req, res, model);
		
		return "customer/cart/cart_pdchkAction_top";
	}
	
	// ========== 장바구니에 상품 추가 처리페이지 ==========
	@RequestMapping("cartAddAction.ct")
	public String cartAddAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /cartAddAction.ct ===");
		
		service.cartPdAddAction(req, res, model);
		
		return "customer/cart/cartAddAction";
	}
}
