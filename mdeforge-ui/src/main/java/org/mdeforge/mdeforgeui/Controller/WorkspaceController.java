package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Model.Workspace;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.mdeforge.mdeforgeui.Service.WorkspaceService;
import org.mdeforge.mdeforgeui.WebApi.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.reactive.result.view.Rendering;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;

import static org.mdeforge.mdeforgeui.Common.Util.getEmailFromOAuth;

@Controller
@RequestMapping("/private/workspace")
public class WorkspaceController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;
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

    @PostMapping("/create")
    public String createWorkspace(@Valid Workspace workspace, @AuthenticationPrincipal User user, BindingResult result, Model model){

        if(result.hasErrors()){ return createWorkspaceView(workspace, user, model);}

        List<String> projectList = new ArrayList<>();
        workspace.getProjects().forEach(project -> {
            projectList.add(project.getId());
        });

        WorkspaceRequest workspaceRequest = new WorkspaceRequest(workspace.getName(), workspace.getDescription(), user != null ? user.getId() : userService.findUserByEmail(getEmailFromOAuth()).getId() , projectList);

        workspaceService.createWorkspace(workspaceRequest);
        return createWorkspaceView(workspace, user, model);
    }


}
