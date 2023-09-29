 package com.sistema.examenes;

/*import java.util.HashSet;
import java.util.Set; 

import org.springframework.beans.factory.annotation.Autowired;*/
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
/*import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.sistema.examenes.models.Role;
import com.sistema.examenes.models.User;
import com.sistema.examenes.models.UserRole; 
import com.sistema.examenes.services.UserService; */

@SpringBootApplication
public class SistemaExamenesBackendApplication implements CommandLineRunner {


	/*@Autowired
	private UserService userService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;*/

	public static void main(String[] args) {
		SpringApplication.run(SistemaExamenesBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		/*User user = new User();

		user.setName("Sebas");
		user.setLastname("Andrango");
		user.setUsername("sebas");
		user.setPassword(bCryptPasswordEncoder.encode("123456"));
		user.setEmail("sebas@gmail.com");
		user.setTelephone("123456789");
		user.setProfile("foto.png");

		Role role = new Role();
		role.setRoleId(1L);
		role.setName("ADMIN");

		Set<UserRole> userRoles = new HashSet<>();
		UserRole userRole = new UserRole();
		userRole.setRole(role);
		userRole.setUser(user);
		userRoles.add(userRole);

		User userSave = userService.saveUser(user, userRoles);
		System.out.println(userSave.getUsername()); */

	}

}
