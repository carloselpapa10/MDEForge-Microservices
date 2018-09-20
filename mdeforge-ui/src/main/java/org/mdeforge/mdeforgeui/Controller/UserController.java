package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/private/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/list")
    public @ResponseBody List<User> getUserList(){

        List<User> userList = userService.findAllUsers();
        return userList;
    }
}
