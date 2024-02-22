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

import spring.mvc.basic_1team.service.Us_product_ServiceImpl;

@Controller
public class Us_product_Controller {

	@Autowired
	private Us_product_ServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(Us_product_Controller.class);
	
	// ========== Outer 상품 화면 ==========
	@RequestMapping("product_Outer.uspd")
	public String product_Outer(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_Outer.uspd ===");
		
		service.usListAction(req, res, model);
		
		return "customer/product/us_product/product_Outer";
	}
	
	// ========== Top 상품 화면 ==========
	@RequestMapping("product_Top.uspd")
	public String product_Top(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_Top.uspd ===");
		
		service.usListAction(req, res, model);
		
		return "customer/product/us_product/product_Top";
	}
	
	// ========== Bottom 상품 화면 ==========
	@RequestMapping("product_Bottom.uspd")
	public String product_Bottom(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_Bottom.uspd ===");
		
		service.usListAction(req, res, model);
		
		return "customer/product/us_product/product_Bottom";
	}
	
	// ========== Outer 상품 상세화면 ==========
	@RequestMapping("product_Outer_detail.uspd")
	public String product_Outer_detail(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_Outer_detail.uspd ===");
		
		service.usListDetailAction(req, res, model);
		
		return "customer/product/us_product_detail/product_Outer_detail";
	}
	
	// ========== Top 상품 상세화면 ==========
	@RequestMapping("product_Top_detail.uspd")
	public String product_Top_detail(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_Top_detail.uspd ===");
		
		service.usListDetailAction(req, res, model);
		
		return "customer/product/us_product_detail/product_Top_detail";
	}
	
	// ========== Bottom 상품 상세화면 ==========
	@RequestMapping("product_Bottom_detail.uspd")
	public String product_Bottom_detail(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_Bottom_detail.uspd ===");
		
		service.usListDetailAction(req, res, model);
		
		return "customer/product/us_product_detail/product_Bottom_detail";
	}
}
