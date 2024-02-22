package spring.mvc.basic_1team.dao;

import java.util.Map;
import java.util.Properties;

import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import spring.mvc.basic_1team.dto.CustomerDTO;
import spring.mvc.basic_1team.util.SettingValues;

@Repository
public class CustomerDAOImpl implements CustomerDAO {

	@Autowired
	private SqlSession sqlSession;
	
	// 회원가입 처리
	@Override
	public int insertCustomer(CustomerDTO dto) {
		System.out.println("dao - insertCustomer");
		
		int insertCnt = sqlSession.insert("spring.mvc.basic_1team.dao.CustomerDAO.insertCustomer",dto);
		
		return insertCnt;
	}

	// 로그인 처리 / 회원정보 인증(수정, 탈퇴)
	@Override
	public int idpasswordChk(Map<String,Object> map) {
		System.out.println("dao - idpasswordChk");
		
		int selectCnt = sqlSession.selectOne("spring.mvc.basic_1team.dao.CustomerDAO.idpasswordChk",map);
		return selectCnt;
	}

	// 회원탈퇴 처리
	@Override
	public int deleteCustomer(String strId) {
		System.out.println("dao - deleteCustomer");
		
		int deleteCnt = sqlSession.delete("spring.mvc.basic_1team.dao.CustomerDAO.deleteCustomer",strId);
		
		return deleteCnt;
	}

	// 회원 상세페이지
	@Override
	public CustomerDTO getCustomerDetail(String strId) {
		System.out.println("dao - getCustomerDetail");
		
		int selectCnt = 0;
		
		CustomerDTO dto = sqlSession.selectOne("spring.mvc.basic_1team.dao.CustomerDAO.getCustomerDetail",strId);
		
		return dto;
	}

	// 회원정보 수정 처리
	@Override
	public int updateCustomer(CustomerDTO dto) {
		System.out.println("dao - updateCustomer");
		
		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.CustomerDAO.updateCustomer",dto);
		return updateCnt;
	}

	// 시큐리티 - 회원가입 성공시 이메일 인증을 위한 이메일정보 전송
	@Override
	public void sendEmail(String email, String key) {
		System.out.println("dao - sendEmail");
		
		final String user_name = SettingValues.ADMIN;
		final String user_pwd = SettingValues.PW;
		
		// naver의 이메일 > 환경설정 > POP3/IMAP 설정
		final String host = "smtp.naver.com";
		int port = 465;
		
		// 메일내용
		String recipient = "woohyun7722@naver.com";
		String subject = "회원가입 인증 메일";
		String content = "링크를 눌러 회원가입을 확인하세요"
				+"<a href='http://localhost/basic_1team/emailChkAction.do?key=" + key + "'>링크</a>";
		
		Properties props = System.getProperties();
		
		// 정보를 담기 위한 객체 생성
	    // SMTP 서버 설정 정보
		props.put("mail.smtp.host", host);
		props.put("mail.smtp.port", port);
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.ssl.enable", "true");
		props.put("mail.smtp.ssl.trust", host);
		
		// Session 생성
		Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
			String uname = user_name;
			String pwd = user_pwd;
			protected javax.mail.PasswordAuthentication getPasswordAuthentication(){
				 return new javax.mail.PasswordAuthentication(uname, pwd);
			}
		});
		
		session.setDebug(true);
		
		try {
			// import javax.mail.Message;
			Message mimeMessage = new MimeMessage(session); // MimeMessage 생성
			mimeMessage.setFrom(new InternetAddress("woohyun7722@naver.com"));
			mimeMessage.setRecipient(Message.RecipientType.TO,new InternetAddress(recipient));
			mimeMessage.setSubject(subject); 
			mimeMessage.setContent(content,"text/html; charset=utf-8");
			Transport.send(mimeMessage);
			System.out.println("<<< Email SEND >>>");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 시큐리티 - 로그인전에 이메일 인증을 해야 한다.
	@Override
	public int selectKey(String key) {
		System.out.println("dao - selectKey");
		int selectCnt = sqlSession.selectOne("spring.mvc.basic_1team.dao.CustomerDAO.selectKey",key);
		System.out.println("dao - selectCnt:"+selectCnt);
		
		return selectCnt;
	}

	//시큐리티 - 등급변경 :로그인시 이메일 인증을 한경우 1로 수정하라
	@Override
	public int updateGrade(String key) {
		System.out.println("dao - updateGrade");
		int updateCnt = sqlSession.update("spring.mvc.basic_1team.dao.CustomerDAO.updateGrade",key);
		System.out.println("dao - updateCnt:"+updateCnt);
		return updateCnt;
	}

	
}