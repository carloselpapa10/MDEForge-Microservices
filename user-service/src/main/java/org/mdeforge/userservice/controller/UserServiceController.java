package org.mdeforge.userservice.controller;

import org.mdeforge.userservice.dao.UserService;
import org.mdeforge.userservice.model.*;
import org.mdeforge.userservice.webapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class UserServiceController {

	private static final Logger log = LoggerFactory.getLogger(UserServiceController.class);

	@Autowired
	private UserService userService;

	@PostMapping("createUser/user")
	public CreateUserResponse createUser(@RequestBody CreateUserRequest request){
		log.info("createUser(@RequestBody CreateUserRequest createUserRequest) - UserServiceController - UserService");

		User user = userService.createUser(new User(request.getFirstname(), request.getLastname(), request.getEmail(), request.getUsername()));
		return new CreateUserResponse(user.getId());
	}
			
	@PutMapping("/updateUser/user")
	public ResponseEntity<User> updateUser(@RequestBody User user){
		log.info("updateUser(@RequestBody User user) - UserServiceController - UserService");

		/*TODO*/
		return null;
	}
 			
	@GetMapping("/findUser/{userId}")
	public User findUser(@RequestParam String id){
		log.info("findUser(String id) - UserServiceController - UserService");

		return userService.findUser(id);
	} 			

	@GetMapping("/retrieve/Users")
	public List<User> findAllUsers(){
		/*Auto-Generated*/
		log.info("findAll() - UserServiceController - UserService");
		return userService.findAll();
	}

}


