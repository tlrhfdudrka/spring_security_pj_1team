package spring.mvc.basic_1team.service;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

public interface CustomerService {

	//회원가입 처리
	public void signInAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	//시큐리티 - 이메일 인증키 추가
	public void EmailChkHandler(HttpServletRequest req, Model model) 
			throws ServletException, IOException;
	
	//시큐리티 - 메일 인증후 권한(enabled) update
	public void emailChkAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	//로그인 처리 / 회원정보 인증(수정,탈퇴)
	public void loginAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	// 탈퇴 처리
	public void deleteCustomerAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	//회원정보 인증처리 및 상세페이지
	public void modifyDetailAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;
	
	//회원정보 수정 처리
	public void modifyCustomerAction(HttpServletRequest req, Model model)
			throws ServletException, IOException;




}