package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Model.Workspace;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.mdeforge.mdeforgeui.Service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

import static org.mdeforge.mdeforgeui.Common.Util.getEmailFromOAuth;

@Controller
@RequestMapping("/private/workspace")
public class WorkspaceController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping("/create")
    public String createWorkspaceView(@ModelAttribute Workspace workspace, @AuthenticationPrincipal User user, Model model){

        model.addAttribute("projectList", projectService.findProjectListByUserEmail(user != null ? user.getEmail() : getEmailFromOAuth()));
        return "private/workspace/insert";
    }

    @GetMapping("/list")
    Rendering listWorkspaceView(@AuthenticationPrincipal User user, Model model){

        model.addAttribute("workspaceList", workspaceService.findWorkspaceListByUserEmail(user != null ? user.getEmail() : getEmailFromOAuth()));
        return Rendering.view("private/workspace/list")
                .build();
    }


}
