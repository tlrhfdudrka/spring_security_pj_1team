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

import spring.mvc.basic_1team.dto.CartDTO;

public class CartDAOImpl implements CartDAO{
	
	@Autowired
	private SqlSession sqlSession;
	
	// 장바구니 목록
	@Override
	public List<CartDTO> cartList(String user_id) {
		System.out.println("<< DAO - cartList >>");
		
		
		String sql = "SELECT ct.*, pd.pd_name AS ct_pdname , pd.pd_img1 AS ct_pdimg, pd.pd_price AS ct_pdprice "
				+ "    FROM pj_cart_tbl ct JOIN pj_product_tbl pd "
				+ "      ON ct.pd_num = pd.pd_num "
				+ "     AND ct.is_delete = 'y' AND ct.is_payment = 'y' AND ct.user_id = ?"
				+ "ORDER BY ct.cart_num desc";
		
		return list;
	}

	// 장바구니 전체상품총액
	@Override
	public int cartTotalPrice(String user_id) {
		System.out.println("<< DAO - cartTotalPrice >>");
		int totalPrice = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select sum(pd.pd_price * ct.cart_cnt) AS cart_total_price "
				+ "FROM pj_cart_tbl ct JOIN pj_product_tbl pd "
				+ "ON ct.pd_num = pd.pd_num "
				+ "AND ct.is_delete = 'y' AND ct.is_payment = 'y' AND ct.user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				totalPrice = rs.getInt("cart_total_price");
			}
			else {
				totalPrice = 0;
			}
			
			System.out.println("totalPrice : " + totalPrice);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return totalPrice;
	}
	
	// 장바구니 선택된 상품총액
	@Override
	public int cartSelectpdPrice(String user_id) {
		System.out.println("<< DAO - cartSelectpdPrice >>");
		
		int selectpdPrice = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "select sum(pd.pd_price * ct.cart_cnt) AS cart_total_price "
				+ "FROM pj_cart_tbl ct JOIN pj_product_tbl pd "
				+ "ON ct.pd_num = pd.pd_num "
				+ "AND ct.is_delete = 'y' AND ct.is_payment = 'y' AND ct.is_chkbox = 'n' AND ct.user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				selectpdPrice = rs.getInt("cart_total_price");
			}
			else {
				selectpdPrice = 0;
			}
			
			System.out.println("selectpdPrice : " + selectpdPrice);
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return selectpdPrice;
	}
	
	// 장바구니 상품 삭제 (y: 삭제안함, n: 삭제함)
	@Override
	public void cartPdDelete(int cart_num) {
		System.out.println("<< DAO - cartPdDelete >>");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE pj_cart_tbl SET is_delete = 'n' WHERE cart_num = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 장바구니 상품 수정(수량)
	@Override
	public void cartUpdate(int cart_num, int cart_cnt) {
		System.out.println("<< DAO - cartUpdate >>");
	
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE pj_cart_tbl SET cart_cnt = ? WHERE cart_num = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_cnt);
			pstmt.setInt(2, cart_num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 장바구니 상품 체크박스 선택시
	@Override
	public void cartPdchecked(int cart_num) {
		System.out.println("<< DAO - cartPdchecked >>");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE pj_cart_tbl SET is_chkbox = 'n' WHERE cart_num = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	//장바구니 상품 체크박스 비선택시
	@Override
	public void cartPdNotcheked(int cart_num) {
		System.out.println("<< DAO - cartPdNotcheked >>");
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE pj_cart_tbl SET is_chkbox = 'y' WHERE cart_num = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, cart_num);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
	}

	// 장바구니 상품 추가시 중복확인
	@Override
	public int cart_pdchk(String user_id, int pd_num) {
		System.out.println("<< DAO - cart_pdchk >>");
		
		int selectCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "SELECT * FROM pj_cart_tbl WHERE user_id = ? AND pd_num = ? AND is_payment = 'y' AND is_delete = 'y'";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			pstmt.setInt(2, pd_num);
			
			rs = pstmt.executeQuery();
			if(rs.next()) {
				selectCnt = 1;
			}
			
			System.out.println("selectCnt : " + selectCnt);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return selectCnt;
	}
	
	// 장바구니 상품 추가
	@Override
	public int cartPdAdd(CartDTO dto) {
		System.out.println("<< DAO - cartPdAdd >>");
		
		int insertCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		try {
			conn = dataSource.getConnection();
			String sql = "INSERT INTO pj_cart_tbl (cart_num, user_id, pd_num) "
					+ "VALUES ((SELECT NVL(MAX(cart_num)+1, 1) FROM pj_cart_tbl), ?, ?)";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getUser_id());
			pstmt.setInt(2, dto.getPd_num());
			// pstmt.setInt(3, dto.getCart_cnt());
			
			insertCnt = pstmt.executeUpdate();
			System.out.println("insertCnt : " + insertCnt);
			
		} catch(SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return insertCnt;
	}
}
