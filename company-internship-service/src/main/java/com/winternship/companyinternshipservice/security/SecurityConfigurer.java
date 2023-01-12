package com.winternship.companyinternshipservice.security;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabase;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseBuilder;
import org.springframework.jdbc.datasource.embedded.EmbeddedDatabaseType;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.jdbc.JdbcDaoImpl;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfigurer{
	
	@Bean
	JdbcUserDetailsManager users(DataSource dataSource) {
		JdbcUserDetailsManager jdbc = new JdbcUserDetailsManager(dataSource);
		return jdbc;
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		http
		.csrf(csrf -> csrf.ignoringAntMatchers("/h2-console/**"))
        .authorizeHttpRequests( authorizeConfig ->{
        	authorizeConfig.antMatchers("/test").authenticated();
        	authorizeConfig.antMatchers("/h2-console/**").permitAll();
        	authorizeConfig.anyRequest().authenticated();
        })
        .headers(headers -> headers.frameOptions().sameOrigin())
        .formLogin()
        .and()
        .logout()
        .clearAuthentication(true)
        .invalidateHttpSession(true);
    return http.build();
		
		

	}

	


}
