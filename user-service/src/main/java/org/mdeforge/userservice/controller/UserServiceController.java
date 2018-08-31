package org.mdeforge.userservice.controller;

import org.mdeforge.userservice.impl.*;
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
	private UserServiceImpl userServiceImpl;

	@PostMapping("createUser/user")
	public CreateUserResponse createUser(@RequestBody CreateUserRequest createUserRequest){
		log.info("createUser(@RequestBody CreateUserRequest createUserRequest) - UserServiceController - UserService");
		
		/*TODO*/
		return new CreateUserResponse();
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
		
		/*TODO*/
		return null;
	} 			

	@GetMapping("/retrieve/Users")
	public List<User> findAllUsers(){
		/*Auto-Generated*/
		log.info("findAll() - UserServiceController - UserService");
		return userServiceImpl.findAll();
	}

}


