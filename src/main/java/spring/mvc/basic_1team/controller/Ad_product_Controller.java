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
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.basic_1team.service.Ad_product_ServiceImpl;

@Controller
public class Ad_product_Controller {
	
	@Autowired
	private Ad_product_ServiceImpl service;
	
	private static final Logger logger = LoggerFactory.getLogger(Ad_product_Controller.class);
	
	// ========== 상품 목록 화면 ==========
	@RequestMapping("product_list.pd")
	public String product_list(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_list.pd ===");
		
		service.pdListAction(req, res, model);
		
		return "admin/ad_product/product_list";
	}
	
	// ========== 상품 등록 화면 ==========
	@RequestMapping("product_add.pd")
	public String product_add(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_add.pd ===");
		
		return "admin/ad_product/product_add";
	}
	
	// ========== 상품 등록 처리 ==========
	@RequestMapping("product_addAction.pd")
	public String product_addAction(MultipartHttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_addAction.pd ===");
		
		service.pdInsertAction(req, res, model);
		
		return "admin/ad_product/product_addAction";
	}
	
	// ========== 상품 상세페이지 처리 ==========
	@RequestMapping("product_listDetail.pd")
	public String product_listDetail(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_listDetail.pd ===");
		
		service.pdListDetailAction(req, res, model);
		
		return "admin/ad_product/product_listDetail";
	}
	
	// ========== 상품 수정 처리 ==========
	@RequestMapping("product_editAction.pd")
	public String product_editAction(MultipartHttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_editAction.pd ===");
		
		service.pdUdateAction(req, res, model);
		
		return "admin/ad_product/product_editAction";
	}
	
	// ========== 상품 삭제 처리 ==========
	@RequestMapping("product_deleteAction.pd")
	public String product_deleteAction(HttpServletRequest req, HttpServletResponse res, Model model) 
			throws ServletException, IOException {
		
		logger.info("=== url : /product_deleteAction.pd ===");
		
		service.pdDeleteAction(req, res, model);
		
		return "admin/ad_product/product_deleteAction";
	}

}
