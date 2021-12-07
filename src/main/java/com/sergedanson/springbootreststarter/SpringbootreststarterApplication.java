package com.sergedanson.springbootreststarter;

import com.sergedanson.springbootreststarter.rolesandpermissions.Modules.Role;
import com.sergedanson.springbootreststarter.rolesandpermissions.Services.RoleServices;
import com.sergedanson.springbootreststarter.usermanagement.Modules.User;
import com.sergedanson.springbootreststarter.usermanagement.Services.UserServices;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;

@SpringBootApplication
public class SpringbootreststarterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootreststarterApplication.class, args);
	}




	@Bean
	CommandLineRunner run(UserServices userServices, RoleServices roleServices){
		return args -> {
			userServices.saveUser(new User(null, "James", "Brown", "james@gmail.com","12345678", new ArrayList<>()));
			userServices.saveUser(new User(null, "Jane", "Doe", "jane.doe@gmailcom","123456789", new ArrayList<>()));


			roleServices.saveRole(new Role(null, "ROLE_USER"));
			roleServices.saveRole(new Role(null, "ROLE_MANAGER"));
			roleServices.saveRole(new Role(null, "ROLE_ADMIN"));

			userServices.addRoleToUser("james@gmail.com","ROLE_USER");
			userServices.addRoleToUser("jane.doe@gmailcom","ROLE_ADMIN");

		};
	}

}
