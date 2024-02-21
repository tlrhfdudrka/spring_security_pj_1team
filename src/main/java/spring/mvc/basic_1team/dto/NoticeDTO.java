package spring.mvc.basic_1team.dto;

import java.sql.Date;

public class NoticeDTO {
	
	private int notice_num;			// 게시글번호
	private String user_id ;		// 회원아이디
	private String notice_pwd;		// 수정, 삭제용 비밀번호
	private String notice_title;	// 게시글제목
	private String notice_content;	// 게시글내용
	private int notice_readCnt;		// 조회수
	private Date notice_date;		// 등록일
	
	// 디폴트생성자
	public NoticeDTO() {
		super();
	}

	public int getNotice_num() {
		return notice_num;
	}

	public void setNotice_num(int notice_num) {
		this.notice_num = notice_num;
	}

	public String getUser_id() {
		return user_id;
	}

	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}

	public String getNotice_pwd() {
		return notice_pwd;
	}

	public void setNotice_pwd(String notice_pwd) {
		this.notice_pwd = notice_pwd;
	}

	public String getNotice_title() {
		return notice_title;
	}

	public void setNotice_title(String notice_title) {
		this.notice_title = notice_title;
	}

	public String getNotice_content() {
		return notice_content;
	}

	public void setNotice_content(String notice_content) {
		this.notice_content = notice_content;
	}

	public int getNotice_readCnt() {
		return notice_readCnt;
	}

	public void setNotice_readCnt(int notice_readCnt) {
		this.notice_readCnt = notice_readCnt;
	}

	public Date getNotice_date() {
		return notice_date;
	}

	public void setNotice_date(Date notice_date) {
		this.notice_date = notice_date;
	}

	@Override
	public String toString() {
		return "NoticeDTO [notice_num=" + notice_num + ", user_id=" + user_id + ", notice_pwd=" + notice_pwd
				+ ", notice_title=" + notice_title + ", notice_content=" + notice_content + ", notice_readCnt="
				+ notice_readCnt + ", notice_date=" + notice_date + "]";
	}
}
