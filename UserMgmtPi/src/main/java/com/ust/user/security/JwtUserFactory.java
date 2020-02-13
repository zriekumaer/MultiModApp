package com.ust.user.security;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import com.ust.user.service.bo.UserBO;


public class JwtUserFactory {
	
	private JwtUserFactory() {
		
	}
	
	public static JwtUser create(UserBO user) {
		return new JwtUser(user.getId().longValue(), user.getEmail(), user.getPassword(), mapToGrantedAuthorities(user.getRoleName()));
	}
	
	private static List<GrantedAuthority> mapToGrantedAuthorities(String roleName){
		List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(roleName));
		return authorities;
	}

}