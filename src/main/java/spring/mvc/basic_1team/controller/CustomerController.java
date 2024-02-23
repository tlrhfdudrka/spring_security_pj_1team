package spring.mvc.basic_1team.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import spring.mvc.basic_1team.service.CustomerServiceImpl;

@Controller
public class CustomerController {

	private static final Logger logger = LoggerFactory.getLogger(CustomerController.class);

	@Autowired
	private CustomerServiceImpl service; // 인터페이스에 대한 의존성 주입

	// 첫페이지
	@RequestMapping("index.do")
	public String index() {
		logger.info("<<< url => /index.do >>>");

		return "common/index";
	}

	// 회원가입
	@RequestMapping("join.do")
	public String join() {
		logger.info("<<< url => /join.do >>>");

		return "customer/join/join";
	}

	// 회원가입 처리 - 시큐리티 (비밀번호 암호화)
	@RequestMapping("joinAction.do")
	public String joinAction(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("<<< url ==> /joinAction.do >>>");

		service.signInAction(req, model);
		return "customer/join/joinAction";

	}

	// 시큐리티 - 가입 성공시 이메일 인증을 위해서 이메일 인증후 enabled 권한을 1로 update
	@RequestMapping("emailChkAction.do")
	public String emailChkAction(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("<<< url ==> /emailChkAction.do >>>");

		service.emailChkAction(req, model);
		return "customer/join/emailChkAction";

	}

	// -- [ 로그인 ] --
	// 로그인 화면
	@RequestMapping("login.do")
	public String login() throws ServletException, IOException {
		logger.info("<<< url ==> /login.do >>>");

		return "customer/login/login";
	}

	
	  // 로그인 처리(시큐리티 사용안함)
	  
	  @RequestMapping("loginAction.do") public String
	  loginAction(HttpServletRequest req, Model model) throws ServletException,
	  IOException { logger.info("<<< url ==> /loginAction.do >>>");
	  
	  service.loginAction(req, model); return "customer/login/loginAction";
	  
	  }
	 

	// 로그아웃
	@RequestMapping("logout.do")
	public String logout(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("<<< url ==> /logout.do >>>");

		// 세션 삭제
		req.getSession().invalidate();
		return "common/index";

	}

	
	/*
	 * // -- [ 회원탈퇴 ] -- // 회원탈퇴 - 인증화면(시큐리티 사용안함)
	 * 
	 * @RequestMapping("deleteCustomer.do") public String deleteCustomer() throws
	 * ServletException, IOException {
	 * logger.info("<<< url ==> /deleteCustomer.do >>>");
	 * 
	 * return "customer/join/deleteCustomer"; }
	 */
	 

	// 회원탈퇴 처리
	@RequestMapping("deleteCustomerAction.do")
	public String deleteCustomerAction(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("<<< url ==> /deleteCustomerAction.do >>>");

		service.deleteCustomerAction(req, model);
		return "customer/join/deleteCustomerAction";

	}

	// 회원수정 상세페이지
	@RequestMapping("modifyDetailAction.do")
	public String modifyDetailAction(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("<<< url ==> /modifyDetailAction.do >>>");

		service.modifyDetailAction(req, model);
		return "customer/join/modifyDetailAction";
	}

	/*
	 * // -- [ 회원수정 ] -- // 회원수정 - 인증화면(시큐리티 사용안함)
	 * 
	 * @RequestMapping("modifyCustomer.do") public String modifyCustomer() throws
	 * ServletException, IOException {
	 * logger.info("<<< url ==> /modifyCustomer.do >>>");
	 * 
	 * return "customer/join/modifyCustomer"; }
	 */

	// 회원수정 처리페이지
	@RequestMapping("modifyCustomerAction.do")
	public String modifyCustomerAction(HttpServletRequest req, Model model) throws ServletException, IOException {
		logger.info("<<< url ==> /modifyCustomerAction.do >>>");

		service.modifyCustomerAction(req, model);
		return "customer/join/modifyCustomerAction";

	}

}