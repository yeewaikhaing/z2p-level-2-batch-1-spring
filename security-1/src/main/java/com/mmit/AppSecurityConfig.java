package com.mmit;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class AppSecurityConfig {

	@Bean
	public UserDetailsService userDetailsService() {
		PasswordEncoder encoder = passwordEncoder();
		
		UserDetails user1 = User
								.withUsername("jk@gmail.com")
								.password(encoder.encode("123"))
								.roles("admin")
								.build();
		UserDetails user2 = User
				.withUsername("abc@gmail.com")
				.password(encoder.encode("123"))
				.roles("staff")
				.build();
		UserDetails user3 = User
				.withUsername("customer@gmail.com")
				.password(encoder.encode("123"))
				.roles("customer")
				.build();
		InMemoryUserDetailsManager provider = new InMemoryUserDetailsManager();
		provider.createUser(user1);
		provider.createUser(user2);
		provider.createUser(user3);
		
		return provider;
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.authorizeRequests()
			.antMatchers("/", "/css/**").permitAll()
			.antMatchers("/product/edit/**", "/product/delete/**").hasRole("admin")
			.antMatchers("/proudct/add").hasAnyRole("admin", "staff")
			.anyRequest()
			.authenticated() // filter/ authorize
			.and()
			//.httpBasic()
			.formLogin() // login
				.loginPage("/login")
				.permitAll()
			.and()
			.logout()
				.logoutSuccessUrl("/")
				.permitAll()
			.and()
			.exceptionHandling()
				.accessDeniedPage("/403");
		
		return http.build();
//		http
//        .authorizeHttpRequests((authorize) -> authorize
//            .anyRequest()
//            
//            .authenticated()
//        );
        // ...

  //  return http.build();
	}
	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return PasswordEncoderFactories.createDelegatingPasswordEncoder();
	}
}
