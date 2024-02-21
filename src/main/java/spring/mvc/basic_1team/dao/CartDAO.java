package spring.mvc.basic_1team.dao;

import java.util.List;

import spring.mvc.basic_1team.dto.CartDTO;

public interface CartDAO {

	// 장바구니 목록 
	public List<CartDTO> cartList(String user_id);
	
	// 장바구니 전체상품총액
	public int cartTotalPrice(String user_id);
	
	// 장바구니 선택된 상품총액
	public int cartSelectpdPrice(String user_id);
	
	// 장바구니 상품 삭제 (y: 삭제안함, n: 삭제함)
	public void cartPdDelete(int cart_num); 
		
	// 장바구니 상품 수정(수량)
	public void cartUpdate(int cart_num, int cart_cnt); 
	
	// 장바구니 상품 체크박스 선택시
	public void cartPdchecked(int cart_num);
	
	//장바구니 상품 체크박스 비선택시
	public void cartPdNotcheked(int cart_num);
	
	// 장바구니 상품 추가시 중복확인
	public int cart_pdchk(String user_id, int pd_num);
	
	// 장바구니 상품 추가
	public int cartPdAdd(CartDTO dto);
}
