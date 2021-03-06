package com.example.demo.security;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.dao.AbstractUserDetailsAuthenticationProvider;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Component;
@Component
public class MyAuthenticationProvider extends AbstractUserDetailsAuthenticationProvider {
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
	protected void additionalAuthenticationChecks(UserDetails userDetails,
			UsernamePasswordAuthenticationToken authentication) throws AuthenticationException {
		//输入的密码
		String inputPassword = (String)authentication.getCredentials();
		//数据库中实际密码
		String actualPassword = userDetails.getPassword();
		
		if(!actualPassword.equals(inputPassword)){
			throw new BadCredentialsException("密码错误！");
		}
	}
	
	/**
	 * 获取用户的详细信息
	 */
	@Override
	protected UserDetails retrieveUser(String username, UsernamePasswordAuthenticationToken authentication)
			throws AuthenticationException {
		UserDetails userDetails=userDetailsService.loadUserByUsername(username);
		return userDetails;
	}

	

}