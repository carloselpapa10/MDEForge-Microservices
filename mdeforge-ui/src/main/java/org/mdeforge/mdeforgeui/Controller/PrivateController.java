package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Security.GoogleOAuth2User;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

import static org.mdeforge.mdeforgeui.Common.Util.getEmailFromOAuth;

@Controller
@RequestMapping("/private")
public class PrivateController {

    @Autowired
    private UserService userService;

    @GetMapping("/dashboard")
    Rendering main(@AuthenticationPrincipal User user, Model model){

        /*
        Workspace workspace = workspaceService.findById(id, user);
		model.addAttribute("workspace", workspace);
		*/

        model.addAttribute("user", userService.findUserByEmail(user != null ? user.getEmail() : getEmailFromOAuth()));
        return Rendering.view("private/dashboard")
                .build();
    }

}
