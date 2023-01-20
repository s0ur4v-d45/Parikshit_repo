package com.exam.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.exam.service.Impl.UserDetailsServiceImpl;




@Configuration
@SuppressWarnings("deprecation")
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class MySecurityConfig
{
	@Autowired
	private JwtAuthenticationFilter jwtAuthenticationFilter;
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Autowired
	private UserDetailsServiceImpl userDetailsServiceImpl;
	

	
	@Bean
	public BCryptPasswordEncoder passwordEncoder()
	{
		return new BCryptPasswordEncoder();
	}

	  @Bean
	  public AuthenticationManager authenticationManager(AuthenticationConfiguration authConfiguration) throws Exception {
	    return authConfiguration.getAuthenticationManager();
	  }
//
//	  @Bean
//	  public AuthenticationManager authenticationManager(HttpSecurity http) throws Exception {
//	      return http.getSharedObject(AuthenticationManagerBuilder.class)
//	              .build();
//	  }
	  
	  @Bean
	  public DaoAuthenticationProvider authenticationProvider() {
	      DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	       
	      authProvider.setUserDetailsService(this.userDetailsServiceImpl);
	      authProvider.setPasswordEncoder(passwordEncoder());
	   
	      return authProvider;
	  }

	  @Bean
	  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
	    
	    
		  http
			  .csrf()
			  .disable()
			  .cors()
			  .disable()
			  .authorizeHttpRequests()
			  .requestMatchers("/generate-token","/user")
			  .permitAll()
			  .requestMatchers(HttpMethod.OPTIONS)
			  .permitAll()
			  .anyRequest().authenticated()
			  .and()
			  .exceptionHandling().authenticationEntryPoint(unauthorizedHandler)
			  .and()
			  .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		  
		    http.authenticationProvider(authenticationProvider());
		  
		  http.addFilterBefore(jwtAuthenticationFilter,UsernamePasswordAuthenticationFilter.class);

	    
	    return http.build();
	}
	
	
	
	
	
	
}
