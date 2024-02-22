package spring.mvc.basic_1team.dto;

import java.util.Date;

public class Ad_product_DTO {

	private int pd_num; 			// 상품번호(PK)
	private int category_num; 		// 카테고리번호
	private String pd_name; 		// 상품명
	private int pd_price; 			// 상품가격
	private int pd_stuck; 			// 상품재고
	private String pd_content; 		// 상품설명
	private String pd_img1; 		// 메인썸네일
	private String pd_img2; 		// 썸네일
	private String pd_detail_img; 	// 상세페이지이미지
	private Date pd_register; 		// 등록날짜
	
	public Ad_product_DTO() {}

	public Ad_product_DTO(int pd_num, int category_num, String pd_name, int pd_price, int pd_stuck, String pd_content,
			String pd_img1, String pd_img2, String pd_detail_img, Date pd_register) {
		
		super();
		this.pd_num = pd_num;
		this.category_num = category_num;
		this.pd_name = pd_name;
		this.pd_price = pd_price;
		this.pd_stuck = pd_stuck;
		this.pd_content = pd_content;
		this.pd_img1 = pd_img1;
		this.pd_img2 = pd_img2;
		this.pd_detail_img = pd_detail_img;
		this.pd_register = pd_register;
	}

	public int getPd_num() {
		return pd_num;
	}

	public void setPd_num(int pd_num) {
		this.pd_num = pd_num;
	}

	public int getCategory_num() {
		return category_num;
	}

	public void setCategory_num(int category_num) {
		this.category_num = category_num;
	}

	public String getPd_name() {
		return pd_name;
	}

	public void setPd_name(String pd_name) {
		this.pd_name = pd_name;
	}

	public int getPd_price() {
		return pd_price;
	}

	public void setPd_price(int pd_price) {
		this.pd_price = pd_price;
	}

	public int getPd_stuck() {
		return pd_stuck;
	}

	public void setPd_stuck(int pd_stuck) {
		this.pd_stuck = pd_stuck;
	}

	public String getPd_content() {
		return pd_content;
	}

	public void setPd_content(String pd_content) {
		this.pd_content = pd_content;
	}

	public String getPd_img1() {
		return pd_img1;
	}

	public void setPd_img1(String pd_img1) {
		this.pd_img1 = pd_img1;
	}

	public String getPd_img2() {
		return pd_img2;
	}

	public void setPd_img2(String pd_img2) {
		this.pd_img2 = pd_img2;
	}

	public String getPd_detail_img() {
		return pd_detail_img;
	}

	public void setPd_detail_img(String pd_detail_img) {
		this.pd_detail_img = pd_detail_img;
	}

	public Date getPd_register() {
		return pd_register;
	}

	public void setPd_register(Date pd_register) {
		this.pd_register = pd_register;
	}

	@Override
	public String toString() {
		return "DTO [pd_num=" + pd_num + ", category_num=" + category_num + ", pd_name=" + pd_name + ", pd_price="
				+ pd_price + ", pd_stuck=" + pd_stuck + ", pd_content=" + pd_content + ", pd_img1=" + pd_img1
				+ ", pd_img2=" + pd_img2 + ", pd_detail_img=" + pd_detail_img + ", pd_register=" + pd_register + "]";
	}
}
