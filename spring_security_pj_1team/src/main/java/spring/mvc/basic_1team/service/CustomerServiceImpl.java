package spring.mvc.basic_1team.service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import spring.mvc.basic_1team.dao.CustomerDAO;
import spring.mvc.basic_1team.dto.CustomerDTO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerDAO dao;
	
	// 회원가입 처리
	@Override
	public void signInAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		System.out.println("서비스 - signInAction");
		
		// DTO 생성
		CustomerDTO dto =  new CustomerDTO();
		
		//dto set으로 값을 불러오기
		dto.setUser_id(req.getParameter("user_id"));
		dto.setUser_pwd(req.getParameter("user_pwd"));
		dto.setUser_name(req.getParameter("user_name"));
		dto.setUser_hp(req.getParameter("user_hp"));
		dto.setUser_email(req.getParameter("user_email"));
		dto.setUser_address(req.getParameter("user_address"));

		// 5단계. 회원가입 처리
		int insertCnt = dao.insertCustomer(dto);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("insertCnt",insertCnt);
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public void loginAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		System.out.println("서비스 - loginAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String strId = req.getParameter("user_id");
		String strPassword = req.getParameter("user_pwd");
		
		// 5단계. 로그인 처리
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("strId",strId );
		map.put("strPassword",strPassword);
		
		int selectCnt = dao.idpasswordChk(map);
		
		// 로그인 성공시 세션ID를 설정
		if(selectCnt == 1) {
			req.getSession().setAttribute("sessionID", strId);
		}
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("selectCnt", selectCnt); // 세션으로 로그인 여부 판단
	}

	// 회원정보 인증처리 및 탈퇴 처리
	@Override
	public void deleteCustomerAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - deleteCustomerAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String strId = (String)req.getSession().getAttribute("sessionID");
		String strPassword = req.getParameter("user_pwd");
		
		// 5-1단계. 회원인증 처리
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("strId", strId);
		map.put("strPassword", strPassword);
		
		int selectCnt = dao.idpasswordChk(map);
		
		// 회원인증 성공시
		int deleteCnt = 0;
		if(selectCnt == 1) {
			// 5-2단계. 회원탈퇴 처리
			deleteCnt = dao.deleteCustomer(strId);
			req.getSession().invalidate();
		}
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("deleteCnt",deleteCnt);
	}

	// 회원정보 인증처리 및 상세페이지
	@Override
	public void modifyDetailAction(HttpServletRequest req, Model model) 
			throws ServletException, IOException {
		System.out.println("서비스 - modifyDetailAction");
		
		// 3단계. 화면에서 입력받은 값을 가져온다.
		String strId = (String)req.getSession().getAttribute("sessionID");
		String strPassword = req.getParameter("user_pwd");
		
		// 5-1단계. 회원인증 처리
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("strId", strId);
		map.put("strPassword", strPassword);
		
		int selectCnt = dao.idpasswordChk(map);
		
		CustomerDTO dto = null;
		if(selectCnt == 1) {
			dto = dao.getCustomerDetail(strId);
		}
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("dto",dto);
		model.addAttribute("selectCnt",selectCnt);
	}

	// 회원정보 수정 처리
	@Override
	public void modifyCustomerAction(HttpServletRequest req, Model model)
			throws ServletException, IOException {
		System.out.println("서비스 - modifyCustomerAction");
		
		// DTO 생성
		CustomerDTO dto = new CustomerDTO();
		
		// 3-2단계. 화면에서 입력받은 값을 가져와서 DTO의 setter로 값 전달
		// 아이디 - 세션ID 
		dto.setUser_id((String)req.getSession().getAttribute("sessionID"));
		dto.setUser_pwd(req.getParameter("user_pwd"));
		dto.setUser_name(req.getParameter("user_name"));
		dto.setUser_hp(req.getParameter("user_hp"));
		dto.setUser_email(req.getParameter("user_email"));
		dto.setUser_address(req.getParameter("user_address"));
		
		// 5단계. 회원수정 처리
		int updateCnt = dao.updateCustomer(dto);
		
		// 6단계. jsp로 처리결과 전달
		model.addAttribute("updateCnt",updateCnt);
		
		
	}
	
}