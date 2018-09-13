package org.mdeforge.mdeforgeui.Security;

import org.mdeforge.mdeforgeui.Model.User;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

@ControllerAdvice
public class SecurityControllerAdvice {

    @ModelAttribute("currentUser")
    User currentUser(@CurrentUser User currentUser){
        return currentUser;
    }
}
