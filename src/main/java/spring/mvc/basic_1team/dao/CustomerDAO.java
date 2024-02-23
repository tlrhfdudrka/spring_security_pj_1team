package spring.mvc.basic_1team.dao;

import java.util.Map;

import spring.mvc.basic_1team.dto.CustomerDTO;

public interface CustomerDAO {

	// 회원가입 처리
	public int insertCustomer(CustomerDTO dto);
	
	//시큐리티 - 회원가입 성공시 이메일 인증을 위한 이메일 정보 전송
	public void sendEmail(String email, String key);
	
	//시큐리티 - 로그인전에 이메일 인증을 해야한다
	public int selectKey(String key);
	
	//시큐리티 - 등급변경
	public int updateGrade(String key);
	
	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	public int idpasswordChk(Map<String,Object> map);
	
	// 회원 탈퇴 처리
	public int deleteCustomer(String strId);
	
	//회원정보 인증처리 및 상세페이지
	public CustomerDTO getCustomerDetail(String strId);
	
	// 회원정보 수정 처리
	public int updateCustomer(CustomerDTO dto);
}