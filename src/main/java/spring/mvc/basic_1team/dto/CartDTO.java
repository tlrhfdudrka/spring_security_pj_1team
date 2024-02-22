package spring.mvc.basic_1team.dto;

public class CartDTO {

	private int cart_num;        // 장바구니 추가상품번호(pk) 
	private String user_id;      // 회원아이디(fk)
	private int pd_num;          // 상품번호(fk)
	private int cart_cnt;        // 수량
	private String is_chkbox;    // 체크박스 선택 여부
	private String ct_pdname;	 // 장바구니 상품명
	private String ct_pdimg;     // 장바구니 상품이미지
	private int ct_pdprice;      // 장바구니 상품가격
	
	
	public CartDTO() {
		super();
	}

	public int getCart_num() {
		return cart_num;
	}

	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public int getPd_num() {
		return pd_num;
	}

	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
	}

	public int getCart_cnt() {
		return cart_cnt;
	}

	public void setCart_cnt(int cart_cnt) {
		this.cart_cnt = cart_cnt;
	}
	
	public String getIs_chkbox() {
		return is_chkbox;
	}

	public void setIs_chkbox(String is_chkbox) {
		this.is_chkbox = is_chkbox;
	}
	
	public String getCt_pdname() {
		return ct_pdname;
	}

	public void setCt_pdname(String ct_pdname) {
		this.ct_pdname = ct_pdname;
	}

	public String getCt_pdimg() {
		return ct_pdimg;
	}

	public void setCt_pdimg(String ct_pdimg) {
		this.ct_pdimg = ct_pdimg;
	}

	public int getCt_pdprice() {
		return ct_pdprice;
	}

	public void setCt_pdprice(int ct_pdprice) {
		this.ct_pdprice = ct_pdprice;
	}


	@Override
	public String toString() {
		return "CartDTO [cart_num=" + cart_num + ", user_id=" + user_id + ", pd_num=" + pd_num + ", cart_cnt="
				+ cart_cnt + ", is_chkbox=" + is_chkbox + ", ct_pdname=" + ct_pdname + ", ct_pdimg=" + ct_pdimg
				+ ", ct_pdprice=" + ct_pdprice + "]";
	}
	
}
