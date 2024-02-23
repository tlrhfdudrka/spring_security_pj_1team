package spring.mvc.basic_1team.dto;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;

public class UserVO extends User {
	public UserVO(String user_name,String user_pwd, boolean enabled, boolean accountNonExpired, boolean credentialsNonExpired, boolean accountNonLocked, Collection<? extends GrantedAuthority>authorities) {
		super(user_name,user_pwd,enabled,accountNonExpired,credentialsNonExpired,accountNonLocked,authorities);
	}
}
