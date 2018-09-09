package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/signup")
public class SignupController {

    private final PasswordEncoder passwordEncoder;
    private final UserService userService;

    public SignupController(PasswordEncoder passwordEncoder, UserService userService) {
        this.passwordEncoder = passwordEncoder;
        this.userService = userService;
    }

    @GetMapping("")
    public String signupForm(@ModelAttribute User user){
        return "signup/form";
    }

    @PostMapping
    public String signup(@Valid User user, BindingResult result){
        if(result.hasErrors()){ return signupForm(user);}
        user.setPassword(this.passwordEncoder.encode(user.getPassword()));

        if(userService.signUp(user) != null){
            return "redirect:/";
        }

        return "signup/form";
    }

}
