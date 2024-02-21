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

import spring.mvc.basic_1team.dto.CustomerDTO;
import spring.mvc.basic_1team.dto.OrderDTO;

public class OrderDAOImpl implements OrderDAO{

	// 커넥션 풀 객체를 보관
	private DataSource dataSource = null;
	
	// 싱글톤 객체 생성
	private static OrderDAOImpl instance = new OrderDAOImpl();
	
	// 디폴트 생성자
	// 커넥션풀 연결(오라클 계정 연결)
	private OrderDAOImpl() {
		try {
			Context context = new InitialContext();
			dataSource = (DataSource) context.lookup("java:comp/env/jdbc/jsp_pj_team1");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}
	
	
	public static OrderDAOImpl getInstance() {
		if(instance == null) {
			instance = new OrderDAOImpl();
		}
		return instance;
	}
	

	// 장바구니 선택상품 결제 여부 수정 (결제 성공 가정하에)
	@Override
	public int isPaymentUpdate1(String user_id) {
		System.out.println("<< DAO - isPaymentUpdate1 >>");
		int updateCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE pj_cart_tbl SET is_payment = 'n' WHERE is_chkbox ='n' AND user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			updateCnt = pstmt.executeUpdate();
			System.out.println("updateCnt : " + updateCnt);
			
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
		
		return updateCnt;
	}

	// 장바구니 전체상품 결제 여부 수정 (결제 성공 가정하에)
	@Override
	public int isPaymentUpdate2(String user_id) {
		System.out.println("<< DAO - isPaymentUpdate2 >>");

		int updateCnt = 0;
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		
		String sql = "UPDATE pj_cart_tbl SET is_payment = 'n' WHERE user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			updateCnt = pstmt.executeUpdate();
			System.out.println("updateCnt : " + updateCnt);
			
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
		
		return updateCnt;
	}

	// 선택 상품 주문결제시 선택상품목록 (상품이미지, 상품명, 같은상품수량, 가격(상품가격*수량))
	@Override
	public List<OrderDTO> selectPdList(String user_id) {
		System.out.println("<< DAO - selectPdList >>");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ct.*, pd.pd_name AS ct_pdname , pd.pd_img1 AS ct_pdimg, (pd.pd_price*ct.cart_cnt) AS ct_pdprice "
				+ "FROM pj_cart_tbl ct JOIN pj_product_tbl pd "
				+ "ON ct.pd_num = pd.pd_num "
				+ "AND ct.is_delete = 'y' AND ct.is_payment = 'y' AND ct.is_chkbox ='n' AND ct.user_id = ? "
				+ "order by ct.cart_num desc";
		
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setCart_num(rs.getInt("cart_num"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setPd_num(rs.getInt("pd_num"));
				dto.setCart_cnt(rs.getInt("cart_cnt"));
				dto.setCt_pdname(rs.getString("ct_pdname"));
				dto.setCt_pdimg(rs.getString("ct_pdimg"));
				dto.setCt_pdprice(rs.getInt("ct_pdprice"));
				
				list.add(dto);
			}
			
			
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
		return list;
	
	}

	// 전체 상품 주문결제시 전체상품목록 (상품이미지, 상품명, 같은상품수량, 가격(상품가격*수량))
	@Override
	public List<OrderDTO> allPdList(String user_id) {
		System.out.println("<< DAO - allPdList >>");

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		String sql = "SELECT ct.*, pd.pd_name AS ct_pdname , pd.pd_img1 AS ct_pdimg, (pd.pd_price*ct.cart_cnt) AS ct_pdprice "
				+ "FROM pj_cart_tbl ct JOIN pj_product_tbl pd "
				+ "ON ct.pd_num = pd.pd_num "
				+ "AND ct.is_delete = 'y' AND ct.is_payment = 'y' AND ct.user_id = ? "
				+ "order by ct.cart_num desc";
		
		List<OrderDTO> list = new ArrayList<OrderDTO>();
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				OrderDTO dto = new OrderDTO();
				dto.setCart_num(rs.getInt("cart_num"));
				dto.setUser_id(rs.getString("user_id"));
				dto.setPd_num(rs.getInt("pd_num"));
				dto.setCart_cnt(rs.getInt("cart_cnt"));
				dto.setCt_pdname(rs.getString("ct_pdname"));
				dto.setCt_pdimg(rs.getString("ct_pdimg"));
				dto.setCt_pdprice(rs.getInt("ct_pdprice"));
				
				list.add(dto);
			}
			
			
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
		return list;
	
	}

	// 회원 정보 가져오기 (주소, 이름, 전화번호)
	@Override
	public CustomerDTO userInfo(String user_id) {
		System.out.println("<< DAO - userInfo >>");
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs =  null;
		// 회원 dto 선언
		CustomerDTO dto = null;
		
		String sql = "select user_name, user_address, user_hp from pj_user_tbl where user_id = ?";
		
		try {
			conn = dataSource.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, user_id);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				
				dto = new CustomerDTO();
				
				dto.setUser_name(rs.getString("user_name"));
				dto.setUser_address(rs.getString("user_address"));
				dto.setUser_hp(rs.getString("user_hp"));
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if(conn != null) conn.close();
				if(pstmt != null) pstmt.close();
				if(rs != null) rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return dto;
	}

	// 장바구니 선택상품 결제 총액 
	@Override
	public int orderTotalPrice1(String user_id) {
		System.out.println("<< DAO - orderTotalPrice1 >>");

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

	// 장바구니 전체상품 결제 총액 
	@Override
	public int orderTotalPrice2(String user_id) {
		System.out.println("<< DAO - orderTotalPrice2 >>");

		int selectpdPrice = 0;
		
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
	
}
