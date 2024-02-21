package spring.mvc.basic_1team.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import spring.mvc.basic_1team.service.ReviewServiceImpl;

@Controller
public class ReviewController {
	
	private static final Logger logger = LoggerFactory.getLogger(ReviewController.class);
	
	@Autowired
	private ReviewServiceImpl service;

	String viewPage = "";
	
	
	// 첫페이지
	@RequestMapping("board_reviewList.rw")
	public String board_reviewList (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /board_reviewList.do >>>");
		
		service.reviewListAction(req, model);
		return "customer/board/review/board_reviewList";
	}
		
	// 상세페이지
	@RequestMapping("board_review.rw")
	public String board_review (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /reviewDetailAction.do >>>");
		
		service.reviewDetailAction(req, model);
		return "customer/board/review/board_review";
	}

	
	
	// 리뷰 게시글 수정 화면
	@RequestMapping("review_Edit.rw")
	public String review_Edit (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /review_Edit.do >>>");
		
		service.ReviewUpdate(req, model);
		return "customer/board/review/board_reviewEdit";
	}

		
	// 리뷰 게시글 수정 처리
	@RequestMapping("board_reviewEdit.rw")
	public String board_reviewEdit (MultipartHttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /board_reviewEdit.do >>>");

          
		service.ReviewUpdateAction(req, model);
		viewPage = req.getContextPath() + "/board_reviewList.rw";
		
		res.sendRedirect(viewPage);
		return null; //This method must return a result of type String
	}
		
		// 리뷰 게시글 삭제 처리
		@RequestMapping("review_deleteAction.rw")
		public String review_deleteAction (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /review_deleteAction.do >>>");
			
			service.ReviewDeleteAction(req, model);
			viewPage = req.getContextPath() + "/board_reviewList.rw";
			
			res.sendRedirect(viewPage); 
			return null;
		}
		
		
		// 리뷰 게시글 작성 화면
		@RequestMapping("review_insert.rw")
		public String review_insert (HttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /review_insert.do >>>");
		
		return "customer/board/review/board_insert";
			
		}
		
		// 리뷰 게시글 작성 처리 
		@RequestMapping("review_insertAction.rw")
		public String review_insertAction (MultipartHttpServletRequest req, HttpServletResponse res,  Model model) throws ServletException, IOException{ 
		logger.info("<<<url ==> /review_insertAction.do >>>");
		
		   
		   service.ReviewInsertAction(req, model);
		   
		   viewPage = req.getContextPath() + "/board_reviewList.rw";
		   res.sendRedirect(viewPage); 
		   return null;
		}
		 
	
		
}
