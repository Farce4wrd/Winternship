package com.winternship.companyinternshipservice.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer{
	
	@Autowired
	@Lazy
	private LoginFilter loginFilter;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
//		http
//			.authorizeHttpRequests((authz) -> authz
//					.anyRequest().authenticated()
//					)
//					.httpBasic(withDefaults());
		http.csrf().disable();
		http.authorizeRequests().anyRequest().authenticated();
		http.addFilterAt(loginFilter, BasicAuthenticationFilter.class);
		
		
		return http.build();
	}
	
	@Bean
	public UserDetailsManager users(DataSource dataSource){
		
		return new JdbcUserDetailsManager(dataSource);
	}

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
		
		return authenticationConfiguration.getAuthenticationManager();
	}

}
