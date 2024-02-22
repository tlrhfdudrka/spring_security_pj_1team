package spring.mvc.basic_1team.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.CartDTO;

@Repository
public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	// 장바구니 목록
	@Override
	public List<CartDTO> cartList(String user_id) {
		
		System.out.println("<< DAO - cartList >>");
		
		List<CartDTO> list = sqlSession.selectList("spring.mvc.basic_1team.dao.CartDAO.cartList", user_id);

		return list;
	}

	// 장바구니 전체상품총액
	@Override
	public int cartTotalPrice(String user_id) {
		
		System.out.println("<< DAO - cartTotalPrice >>");
		
		int totalPrice = sqlSession.selectOne("spring.mvc.basic_1team.dao.CartDAO.cartTotalPrice", user_id);
				
		return totalPrice;
	}
	
	// 장바구니 선택된 상품총액
	@Override
	public int cartSelectpdPrice(String user_id) {
		
		System.out.println("<< DAO - cartSelectpdPrice >>");
		
		int selectpdPrice = sqlSession.selectOne("spring.mvc.basic_1team.dao.CartDAO.cartSelectpdPrice", user_id);
				
		return selectpdPrice;
	}
	
	// 장바구니 상품 삭제 (y: 삭제안함, n: 삭제함)
	@Override
	public void cartPdDelete(int cart_num) {
		System.out.println("<< DAO - cartPdDelete >>");
	
		sqlSession.update("spring.mvc.basic_1team.dao.CartDAO.cartPdDelete", cart_num);

	}

	// 장바구니 상품 수정(수량)
	@Override
	public void cartUpdate(Map<String, Object> map) {
		
		System.out.println("<< DAO - cartUpdate >>");
	
		sqlSession.update("spring.mvc.basic_1team.dao.CartDAO.cartUpdate", map);
	}

	// 장바구니 상품 체크박스 선택시
	@Override
	public void cartPdchecked(int cart_num) {
		
		System.out.println("<< DAO - cartPdchecked >>");
		
		sqlSession.update("spring.mvc.basic_1team.dao.CartDAO.cartPdchecked", cart_num);
	}

	//장바구니 상품 체크박스 비선택시
	@Override
	public void cartPdNotcheked(int cart_num) {
		
		System.out.println("<< DAO - cartPdNotcheked >>");
		
		sqlSession.update("spring.mvc.basic_1team.dao.CartDAO.cartPdNotcheked", cart_num);
	}

	// 장바구니 상품 추가시 중복확인
	@Override
	public int cart_pdchk(Map<String, Object> map) {
		
		System.out.println("<< DAO - cart_pdchk >>");
		
		int selectCnt = sqlSession.selectOne("spring.mvc.basic_1team.dao.CartDAO.cart_pdchk", map);

		return selectCnt;
	}
	
	// 장바구니 상품 추가
	@Override
	public int cartPdAdd(CartDTO dto) {
		
		System.out.println("<< DAO - cartPdAdd >>");
		
		int insertCnt = sqlSession.insert("spring.mvc.basic_1team.dao.CartDAO.cartPdAdd", dto);
		
		return insertCnt;
	}
}
