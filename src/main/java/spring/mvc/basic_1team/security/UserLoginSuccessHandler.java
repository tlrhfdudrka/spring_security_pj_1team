package spring.mvc.basic_1team.security;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import spring.mvc.basic_1team.dto.UserVO;




//로그인 성공시 작동
public class UserLoginSuccessHandler implements AuthenticationSuccessHandler{

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	public UserLoginSuccessHandler(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	//로그인이 성공할 경우 자동으로 실행하는 메서드
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		System.out.println("<<< UserLoginSuccessHandler - onAuthenticationSuccess 진입 >>>");
		
		UserVO vo = (UserVO) authentication.getPrincipal();
		System.out.println("UserVO:" + vo.getUsername());
		
		String msg = authentication.getName() + "님 환영합니다.";
		
		String 	authority = sqlSession.selectOne("spring.mvc.basic_1team.dao.CustomerDAO.authorityCheck",authentication.getName());
		
		request.setAttribute("msg", msg);
		request.getSession().setAttribute("sessionID", authentication.getName()); //세션추가
		request.setAttribute("authority", authority);
		
		int grade = 0;
		String viewPage = "";
		
		if(authority.equals("ROLE_USER")) {
			grade = 1;
			viewPage = "/index.do";
		}
		else {
			grade = 0;
			viewPage = "/board_list.bc";
		}
		
		RequestDispatcher dispatcher = request.getRequestDispatcher(viewPage);
		dispatcher.forward(request, response);

	}

	
}
