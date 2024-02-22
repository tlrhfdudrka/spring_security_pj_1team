package spring.mvc.basic_1team.dao;

import java.util.List;

import spring.mvc.basic_1team.dto.CustomerDTO;
import spring.mvc.basic_1team.dto.OrderDTO;

public interface OrderDAO {
	
	
	// 장바구니 선택상품 결제 여부 수정 (결제 성공 가정하에)
	public int isPaymentUpdate1(String user_id);
	
	// 장바구니 전체상품 결제 여부 수정 (결제 성공 가정하에)
	public int isPaymentUpdate2(String user_id);
	
	// 선택 상품 주문결제시 선택상품목록 (상품이미지, 상품명, 같은상품수량, 가격(상품가격*수량))
	public List<OrderDTO> selectPdList(String user_id);
	
	// 전체 상품 주문결제시 전체상품목록 (상품이미지, 상품명, 같은상품수량, 가격(상품가격*수량))
	public List<OrderDTO> allPdList(String user_id);
	
	// 회원 정보 가져오기 (주소, 이름, 전화번호)
	public CustomerDTO userInfo(String user_id);
	
	// 장바구니 선택상품 결제 총액 
	public int orderTotalPrice1(String user_id);  
	
	// 장바구니 전체상품 결제 총액 
	public int orderTotalPrice2(String user_id);
	
	
}
