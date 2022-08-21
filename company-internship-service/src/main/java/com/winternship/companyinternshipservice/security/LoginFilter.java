package com.winternship.companyinternshipservice.security;

import java.io.IOException;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.google.common.net.HttpHeaders;

@Component
public class LoginFilter extends OncePerRequestFilter{
	
	//private final UserDetailsManager users;
	private final AuthenticationManager authenticationManager;
	private final JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		var username = request.getHeader("username");
		var password = request.getHeader("password");
		
		var authenticated = authenticationManager.authenticate(
				new UsernamePasswordAuthenticationToken(username, password)
				);
		response.setHeader(HttpHeaders.AUTHORIZATION, createJwtToken(authenticated));
	}
	
	private String createJwtToken(Authentication authenticated) {
		var user = (User) authenticated.getPrincipal();
		var roleString = user.getAuthorities().stream()
				.map(GrantedAuthority::getAuthority)
				.collect(Collectors.joining());
		return jwtUtil.createToken(Map.of("role",roleString),user.getUsername());
	}

	@Override
	protected boolean shouldNotFilter(HttpServletRequest request) throws ServletException{
		var method = request.getMethod();
		var uri = request.getRequestURI();
		var isLogin = HttpMethod.POST.matches(method)&&uri.startsWith("/login");
		
		return !isLogin;
	}
	
	
	public LoginFilter(AuthenticationManager authen, JwtUtil jwtUtil) {
		this.authenticationManager = authen;
		this.jwtUtil = jwtUtil;
		
	}
	}
