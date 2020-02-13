package com.ust.user.service.impl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.ust.user.security.JwtUserFactory;
import com.ust.user.service.UserService;
import com.ust.user.service.bo.UserBO;


@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	private UserService userService;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		UserBO user = userService.findUserByEmail(email);
		if(user==null) {
			throw new UsernameNotFoundException(String.format("No user found with username %", email));
		}else {
			return JwtUserFactory.create(user);
		}
	}
	
}