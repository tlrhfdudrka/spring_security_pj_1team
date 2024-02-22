package spring.mvc.basic_1team.security;

import java.util.ArrayList;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import spring.mvc.basic_1team.dto.CustomerDTO;
import spring.mvc.basic_1team.dto.UserVO;





//로그인 인증처리 클래스 : 비밀번호 인증,로그인 성공, 실패,권한없음을 판단
//로그인시 우리가 만든 loginAction.do는 주석처리한다.(login-processing-url="/loginAction.do"부분이 자동호출 되므로)
public class UserAuthenticationService implements UserDetailsService {

	@Autowired
	private SqlSessionTemplate sqlSession;
	
	//security-context.xml에서 매개변수 생성자 호출시 sqlSession의 주소값을 매개변수로 전달
	public UserAuthenticationService(SqlSessionTemplate sqlSession ) {
		this.sqlSession = sqlSession;
	}
	
	
	
	@Override
	public UserDetails loadUserByUsername(String userid) throws UsernameNotFoundException {
		System.out.println("<<< UserAuthenticationService-loadUserByUsername 진입 >>>");
		
		CustomerDTO dto = sqlSession.selectOne("spring.mvc.security_pj_ict02.dao.CustomerDAO.selectCustomer",userid );
		System.out.println("시큐리티 로그인 체크=>" +dto);
		
		//로그인 인증 실패시 인위적으로 예외를 생성하게 던진다.
		if(dto==null)throw new UsernameNotFoundException(userid);
		
		List<GrantedAuthority> authority = new ArrayList<GrantedAuthority>();
		authority.add(new SimpleGrantedAuthority(dto.getAuthority()));
		
		
		//authority(ROLE_USER | ROLE_ADMIN)
				return new UserVO(dto.getUser_id(),dto.getUser_pwd(),dto.getEnabled().equals("1"),
						true,true,true,authority);
				
			}
	
}
