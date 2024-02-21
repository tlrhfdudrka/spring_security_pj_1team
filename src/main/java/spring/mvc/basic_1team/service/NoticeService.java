package spring.mvc.basic_1team.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;

public interface NoticeService {

	// 게시글 목록
	public void noticeListAction(HttpServletRequest req, Model model)
		throws ServletException, IOException;
	
	
	// 게시글 상세페이지
	public void noticeDetailAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	
	// 게시글 수정처리
	public void noticeUpdateAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	
	// 게시글 삭제처리
	public void noticeDeleteAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	
	// 게시글 작성 처리
	public void noticeInsertAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
}
