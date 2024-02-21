package spring.mvc.basic_1team.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface Ad_product_Service {
	
	// 상품 목록
	public void pdListAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException;

	// 상품 등록
	public void pdInsertAction(MultipartHttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException;
	
	// 상품 상세페이지
	public void pdListDetailAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException;
	
	// 상품 수정
	public void pdUdateAction(MultipartHttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException;
	
	// 상품 삭제
	public void pdDeleteAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException;

}
