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

import spring.mvc.basic_1team.service.NoticeServiceImpl;


@Controller
public class NoticeController {

	// 출력문 (HomeController에서 복붙)
	private static final Logger logger = LoggerFactory.getLogger(NoticeController.class);

	@Autowired
	private NoticeServiceImpl service;
	String viewPage = "";
	
	// 게시글 목록
	@RequestMapping("noticeList.nt")
	public String noticeList(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /ad_noticeList.nt >>>");
	
		service.noticeListAction(req, model);
		return "admin/csCenter/board/notice/noticeList";
	}
	
	
	// 게시글 상세페이지
	@RequestMapping("notice_detailAction.nt")
	public String notice_detailAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /notice_detailAction.nt >>>");
	
		service.noticeDetailAction(req, model);
		return "admin/csCenter/board/notice/notice_detailAction";
	}
	
	
	// 게시글 수정 화면
	@RequestMapping("notice_edit.nt")
	public String notice_edit(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /notice_edit.nt >>>");
	
		service.noticeDetailAction(req, model);
		return "admin/csCenter/board/notice/notice_edit";
	}
	
	// 게시글 수정 처리
	@RequestMapping("notice_updateAction.nt")
	public String notice_updateAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /notice_updateAction.nt >>>");
	
		service.noticeUpdateAction(req, model);
		viewPage = req.getContextPath() + "/noticeList.nt";
		res.sendRedirect(viewPage);
		return null;
	}
	
	// 게시글 삭제 처리
	@RequestMapping("notice_deleteAction.nt")
	public String notice_deleteAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /notice_deleteAction.nt >>>");
	
		service.noticeDeleteAction(req, model);
		viewPage = req.getContextPath() + "/noticeList.nt";
		res.sendRedirect(viewPage);
		return null;
	}
	
	// 게시글 작성 화면
	@RequestMapping("notice_insert.nt")
	public String notice_insert(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /notice_insert.nt >>>");
	
		return "admin/csCenter/board/notice/notice_insert";
	}
	
	// 게시글 작성 처리
	@RequestMapping("notice_insertAction.nt")
	public String notice_insertAction(HttpServletRequest req, HttpServletResponse res, Model model)
			throws ServletException, IOException {
		logger.info("<<< url ==> /notice_insertAction.nt >>>");
	
		service.noticeInsertAction(req, model);
		viewPage = req.getContextPath() + "/noticeList.nt";
		res.sendRedirect(viewPage);
		return null;
	}
}
