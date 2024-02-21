package spring.mvc.basic_1team.dto;

import java.sql.Date;

public class ReviewDTO {
	
	private int  review_num;   			//리뷰글번호 
	private String  user_id;    		//회원아이디 
	private String   review_title;      //리뷰제목
	private String   review_content;    //리뷰내용
	private String   review_img;        //리뷰사진 
	//private String   review_pwd;        //수정, 삭제용 비밀번호
	//private int review_comment_count;   //댓글갯수
	private int review_readCnt;         //조회수
	private Date   review_date;         //작성일 
	
	
	public ReviewDTO() {
		super();
	}


	public int getReview_num() {
		return review_num;
	}


	public void setReview_num(int review_num) {
		this.review_num = review_num;
	}


	public String getUser_id() {
		return user_id;
	}


	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}


	public String getReview_title() {
		return review_title;
	}


	public void setReview_title(String review_title) {
		this.review_title = review_title;
	}


	public String getReview_content() {
		return review_content;
	}


	public void setReview_content(String review_content) {
		this.review_content = review_content;
	}


	public String getReview_img() {
		return review_img;
	}


	public void setReview_img(String review_img) {
		this.review_img = review_img;
	}


//	public String getReview_pwd() {
//		return review_pwd;
//	}
//
//
//	public void setReview_pwd(String review_pwd) {
//		this.review_pwd = review_pwd;
//	}
//
//
//	public int getReview_comment_count() {
//		return review_comment_count;
//	}
//
//
//	public void setReview_comment_count(int review_comment_count) {
//		this.review_comment_count = review_comment_count;
//	}


	public int getReview_readCnt() {
		return review_readCnt;
	}


	public void setReview_readCnt(int review_readCnt) {
		this.review_readCnt = review_readCnt;
	}


	public Date getReview_date() {
		return review_date;
	}


	public void setReview_date(Date review_date) {
		this.review_date = review_date;
	}


	@Override
	public String toString() {
		return "ReviewDTO [review_num=" + review_num + ", user_id=" + user_id + ", review_title=" + review_title
				+ ", review_content=" + review_content + ", review_img=" + review_img + ", review_readCnt="
				+ review_readCnt + ", review_date=" + review_date + "]";
	}




	
}


/*
---------------- [ 6. 상품리뷰 테이블 ] ---------------- 
DROP TABLE pj_review_tbl  CASCADE CONSTRAINTS;
CREATE TABLE pj_review_tbl(
   review_num            NUMBER(7)       PRIMARY KEY,                        --리뷰글번호 (pk) 
   user_id              VARCHAR2(50)    REFERENCES pj_user_tbl(user_id),    --회원아이디 (fk)
--   pd_num               NUMBER(7)       REFERENCES pj_product_tbl(pd_num),  --상품번호 (fk)
   review_title         VARCHAR2(50)    NOT NULL,                           --리뷰제목
   review_content       CLOB            NOT NULL ,                          --리뷰내용
   review_img           VARCHAR2(255),                                      --리뷰사진 
   review_date          DATE            DEFAULT sysdate,                    --작성일 
   review_pwd           VARCHAR2(30)    NOT NULL,                           --수정, 삭제용 비밀번호
   review_comment_count NUMBER(6)       DEFAULT 0,                          --댓글갯수
   review_readCnt       NUMBER(6)       DEFAULT 0                           --조회수
);
*/