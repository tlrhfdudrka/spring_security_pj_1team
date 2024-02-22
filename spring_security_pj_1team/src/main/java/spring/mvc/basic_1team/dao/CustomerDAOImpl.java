package spring.mvc.basic_1team.dao;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.CustomerDTO;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {
		System.out.println("dao - insertCustomer");
		
		int insertCnt = sqlSession.insert("spring.mvc.basic_1team.dao.CustomerDAO.insertCustomer",dto);
		
		return insertCnt;
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idpasswordChk(Map<String,Object> map) {
		System.out.println("dao - idpasswordChk");
		
		int selectCnt = sqlSession.selectOne("spring.mvc.basic_1team.dao.CustomerDAO.idpasswordChk",map);
		return selectCnt;
	}

	// 회원탈퇴 처리
	@Override
	public int deleteCustomer(String strId) {
		System.out.println("dao - deleteCustomer");
		
		int deleteCnt = sqlSession.delete("spring.mvc.basic_1team.dao.CustomerDAO.deleteCustomer",strId);
		
		return deleteCnt;
	}

	// 회원 상세페이지
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		System.out.println("dao - getCustomerDetail");
		
		int selectCnt = 0;
		
		CustomerDTO dto = sqlSession.selectOne("spring.mvc.basic_1team.dao.CustomerDAO.getCustomerDetail",strId);
		
		return dto;
	}

	// 회원정보 수정 처리
	@Override
	public int updateCustomer(CustomerDTO dto) {
		System.out.println("dao - updateCustomer");
		
		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.CustomerDAO.updateCustomer",dto);
		return updateCnt;
	}

	
}