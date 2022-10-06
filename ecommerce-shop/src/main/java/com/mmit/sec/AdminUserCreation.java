package com.mmit.sec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.mmit.model.entity.User;
import com.mmit.model.entity.UserRole;
import com.mmit.model.service.UserService;

@Configuration
public class AdminUserCreation {

	@Autowired
	private UserService service;
	@Bean
	public CommandLineRunner runner() {
		return 
			args ->  {
				long count = service.countUser();
				if(count == 0) {
					User user = new User();
					user.setEmail("admin@gmail.com");
					user.setPassword("admin");
					user.setRole(UserRole.admin);
					user.setPhone("09123456789");
					user.setName("admin");
					user.setAddress("Yangon");
					
					service.save(user);
				}
			}
		;
	}
}
