package spring.mvc.basic_1team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.CustomerDTO;
import spring.mvc.basic_1team.dto.OrderDTO;

@Repository
public class OrderDAOImpl implements OrderDAO{

	@Autowired
	private SqlSession sqlSession;
	
	
	// 장바구니 선택상품 결제 여부 수정 (결제 성공 가정하에)
	@Override
	public int isPaymentUpdate1(String user_id) {
		System.out.println("<< DAO - isPaymentUpdate1 >>");
		
		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.OrderDAO.isPaymentUpdate1", user_id);
				
		return updateCnt;
	}

	// 장바구니 전체상품 결제 여부 수정 (결제 성공 가정하에)
	@Override
	public int isPaymentUpdate2(String user_id) {
		System.out.println("<< DAO - isPaymentUpdate2 >>");

		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.OrderDAO.isPaymentUpdate2", user_id);
		
		return updateCnt;
	}

	// 선택 상품 주문결제시 선택상품목록 (상품이미지, 상품명, 같은상품수량, 가격(상품가격*수량))
	@Override
	public List<OrderDTO> selectPdList(String user_id) {
		System.out.println("<< DAO - selectPdList >>");

		List<OrderDTO> list = sqlSession.selectList("spring.mvc.basic_1team.dao.OrderDAO.selectPdList", user_id);
		
		return list;
	
	}

	// 전체 상품 주문결제시 전체상품목록 (상품이미지, 상품명, 같은상품수량, 가격(상품가격*수량))
	@Override
	public List<OrderDTO> allPdList(String user_id) {
		System.out.println("<< DAO - allPdList >>");

		List<OrderDTO> list = sqlSession.selectList("spring.mvc.basic_1team.dao.OrderDAO.allPdList", user_id);
		
		return list;
	
	}

	// 회원 정보 가져오기 (주소, 이름, 전화번호)
	@Override
	public CustomerDTO userInfo(String user_id) {
		System.out.println("<< DAO - userInfo >>");
		
		CustomerDTO dto = sqlSession.selectOne("spring.mvc.basic_1team.dao.OrderDAO", user_id);
				
		return dto;
	}

	// 장바구니 선택상품 결제 총액 
	@Override
	public int orderTotalPrice1(String user_id) {
		System.out.println("<< DAO - orderTotalPrice1 >>");

		int selectpdPrice = sqlSession.selectOne("spring.mvc.basic_1team.dao.OrderDAO", user_id);
				
		return selectpdPrice;
	}

	// 장바구니 전체상품 결제 총액 
	@Override
	public int orderTotalPrice2(String user_id) {
		System.out.println("<< DAO - orderTotalPrice2 >>");

		int selectpdPrice = sqlSession.selectOne("spring.mvc.basic_1team.dao.OrderDAO", user_id);
				
		return selectpdPrice;
	}
	
}
