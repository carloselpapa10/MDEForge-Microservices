package org.mdeforge.userservice.controller;

import org.mdeforge.userservice.dao.UserService;
import org.mdeforge.userservice.model.*;
import org.mdeforge.userservice.webapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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

	@PostMapping("/createUser/user")
	public CreateUserResponse createUser(@RequestBody CreateUserRequest request){
		log.info("createUser(@RequestBody CreateUserRequest createUserRequest) - UserServiceController - UserService");

        if(userService.findUserByEmail(request.getEmail()) == null && userService.findUserByUsername(request.getUsername()) == null){
            User user = userService.createUser(new User(request.getFirstname(),
                                                            request.getLastname(),
                                                                request.getEmail(),
                                                                    request.getUsername(),
                                                                        request.getPassword(),
                                                                            request.getImage()));
            return new CreateUserResponse(user.getId());
        }
        return null;
	}
			
	@PutMapping("/updateUser/user")
	public ResponseEntity<User> updateUser(@RequestBody User request){
		log.info("updateUser(@RequestBody User user) - UserServiceController - UserService");

		User user = userService.updateUser(request);
		return user != null ? ResponseEntity.ok(user) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
 			
	@GetMapping("/findUser/{userId}")
    public User findUser(@PathVariable("userId") String id){
		log.info("findUser(String id) - UserServiceController - UserService");

		return userService.findUser(id);
	}

	@GetMapping("/findUserByEmail/{email:.+}")
    public User findUserByEmail(@PathVariable("email") String email){
        log.info("findUserByEmail(String email) - UserServiceController - UserService");
        return userService.findUserByEmail(email);
    }

    @GetMapping("/findUserByUsername/{username.+}")
    public User findUserByUsername(@PathVariable("username") String username){
        log.info("findUserByEmail(String username) - UserServiceController - UserService");
        return userService.findUserByUsername(username);
    }

	@DeleteMapping("/deleteUser/{userId}")
    public String deleteUser(@PathVariable("userId") String id){
        log.info("deleteUser(String id) - UserServiceController - UserService");

        User user = userService.findUser(id);
        if(user!=null){
            userService.deleteUser(user);
            return "User is being deleted";
        }

        return "User ID does not exist!";
    }

	@GetMapping("/retrieve/Users")
	public List<User> findAllUsers(){
		/*Auto-Generated*/
		log.info("findAll() - UserServiceController - UserService");
		return userService.findAll();
	}

}


