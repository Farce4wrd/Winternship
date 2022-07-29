package com.winternship.companyinternshipservice.security;

import static org.springframework.security.config.Customizer.withDefaults;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer{
	
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
			.authorizeHttpRequests((authz) -> authz
					.anyRequest().authenticated()
					)
					.httpBasic(withDefaults());
		
		
		return http.build();
	}
	
	@Bean
	public UserDetailsManager users(DataSource dataSource){
		//UserDetails user = User.withDe
		return new JdbcUserDetailsManager(dataSource);
	}


}
