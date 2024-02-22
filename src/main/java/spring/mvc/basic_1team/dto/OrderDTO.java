package spring.mvc.basic_1team.dto;

import java.sql.Date;

public class OrderDTO {

	private int order_num;           // 주문번호(pk)
	private String user_id;          // 회원아이디(fk)
	private String recipient;        // 받는사람
	private String re_address;       // 받는사람주소
	private String re_hp;            // 받는분전화번호
	private String order_bank;       // 입금은행
	private String depositor;        // 입금자명
	private Date order_date;         // 주문날짜
	
	private int cart_num;			 // 장바구니 번호
	private int pd_num;              // 상품 번호
	private int cart_cnt;            // 상품수량
	private String ct_pdname;        // 상품이름
	private String ct_pdimg;         // 상품이미지
	private int ct_pdprice;          // 같은상품 총액
	
	public OrderDTO() {
		super();
	}

	public int getOrder_num() {
		return order_num;
	}

	public void setOrder_num(int order_num) {
		this.order_num = order_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public String getRe_address() {
		return re_address;
	}

	public void setRe_address(String re_address) {
		this.re_address = re_address;
	}

	public String getRe_hp() {
		return re_hp;
	}

	public void setRe_hp(String re_hp) {
		this.re_hp = re_hp;
	}

	public String getOrder_bank() {
		return order_bank;
	}

	public void setOrder_bank(String order_bank) {
		this.order_bank = order_bank;
	}

	public String getDepositor() {
		return depositor;
	}

	public void setDepositor(String depositor) {
		this.depositor = depositor;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}
	
	public int getCart_num() {
		return cart_num;
	}

	public void setCart_num(int cart_num) {
		this.cart_num = cart_num;
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
		return "OrderDTO [order_num=" + order_num + ", user_id=" + user_id + ", recipient=" + recipient
				+ ", re_address=" + re_address + ", re_hp=" + re_hp + ", order_bank=" + order_bank + ", depositor="
				+ depositor + ", order_date=" + order_date + ", cart_num=" + cart_num + ", pd_num=" + pd_num
				+ ", cart_cnt=" + cart_cnt + ", ct_pdname=" + ct_pdname + ", ct_pdimg=" + ct_pdimg + ", ct_pdprice="
				+ ct_pdprice + "]";
	}

	
	
}
