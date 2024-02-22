package spring.mvc.basic_1team.dao;

import java.util.Map;

import spring.mvc.basic_1team.dto.CustomerDTO;

public interface CustomerDAO {

	// 회원가입 처리
	public int insertCustomer(CustomerDTO dto);
	
	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	public int idpasswordChk(Map<String,Object> map);
	
	// 회원 탈퇴 처리
	public int deleteCustomer(String strId);
	
	//회원정보 인증처리 및 상세페이지
	public CustomerDTO getCustomerDetail(String strId);
	
	// 회원정보 수정 처리
	public int updateCustomer(CustomerDTO dto);
}