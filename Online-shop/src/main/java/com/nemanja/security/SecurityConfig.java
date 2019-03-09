package com.nemanja.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	//@Autowired
	//private UserDetailsService userDetailsService;
	
	 /*@Bean
	  public BCryptPasswordEncoder passwordEncoder() {
	    return new BCryptPasswordEncoder();
	  };*/
 
	 @Override protected void configure(AuthenticationManagerBuilder auth) throws
	 Exception {
	 auth.inMemoryAuthentication().withUser("mena").password("{noop}12345").roles("admin");
	 //auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder()); 
	 }
	 
	  @Override protected void configure(HttpSecurity http) throws Exception {
	 
	  
	  
	  http.authorizeRequests() .anyRequest().authenticated() .and()
	  .formLogin().loginPage("/login/").loginProcessingUrl("/authenticateTheUser").
	  permitAll(); 
	  // The pages does not require login
	  http.authorizeRequests().antMatchers("/resources/**").permitAll().anyRequest(
	  ).permitAll(); }

}
