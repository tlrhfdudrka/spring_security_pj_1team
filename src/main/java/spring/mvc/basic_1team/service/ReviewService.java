package spring.mvc.basic_1team.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartHttpServletRequest;

public interface ReviewService {

	// 리뷰 게시글 목록
	public void reviewListAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	// 리뷰 게시글 상세페이지
	public void reviewDetailAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	// 리뷰 게시글 수정처리 화면
	public void ReviewUpdate(HttpServletRequest req, Model model)
			throws ServletException, IOException;	
	
	// 리뷰 게시글 수정처리
	public void ReviewUpdateAction(MultipartHttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	// 리뷰 게시글 삭제 처리
	public void ReviewDeleteAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	// 리뷰 게시글 작성 처리
	public void ReviewInsertAction(MultipartHttpServletRequest req, Model model)
			throws ServletException, IOException;
}
