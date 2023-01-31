package com.exam;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.exam.model.Role;
import com.exam.model.User;
import com.exam.model.UserRole;
import com.exam.services.UserService;

@SpringBootApplication
@CrossOrigin("*")
@EnableTransactionManagement
public class ExamserverApplication implements CommandLineRunner{
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamserverApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("starting code");
		
		/*
		 * User user = new User();
		 * 
		 * user.setFirstName("Sourav");
		 * 
		 * user.setLastName("Das");
		 * 
		 * user.setUsername("sourav1");
		 * 
		 * user.setPassword(this.bCryptPasswordEncoder.encode("abc"));
		 * 
		 * user.setEmail("abc@gmail.com");
		 * 
		 * user.setProfile("default.png");
		 * 
		 * 
		 * 
		 * Role role1 = new Role();
		 * 
		 * role1.setRoleId (45L);
		 * 
		 * role1.setRoleName("NORMAL");
		 * 
		 * 
		 * Set<UserRole> userRoleSet = new HashSet<>();
		 * 
		 * UserRole userRole = new UserRole();
		 * 
		 * userRole.setRole(role1);
		 * 
		 * userRole.setUser(user);
		 * 
		 * userRoleSet.add(userRole);
		 * 
		 * User user1 = this.userService.createUser(user, userRoleSet);
		 * 
		 * System.out.println(user1.getUsername());
		 */
	}

}
