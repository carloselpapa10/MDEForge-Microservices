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
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.mdeforge.mdeforgeui.Common.Util.getEmailFromOAuth;

@Controller
@RequestMapping("/private/workspace")
public class WorkspaceController {

    private static final Logger log = LoggerFactory.getLogger(WorkspaceController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;
    @GetMapping("/create")
    public String createWorkspaceView(@ModelAttribute WorkspaceRequest workspaceRequest, @AuthenticationPrincipal User user, Model model){

        model.addAttribute("projectList", projectService.findProjectListByUserEmail(user != null ? user.getEmail() : getEmailFromOAuth()));
        return "private/workspace/insert";
    }

    @GetMapping("/list")
    public String listWorkspaceView(@AuthenticationPrincipal User user, Model model){

        model.addAttribute("workspaceList", workspaceService.findWorkspaceListByUserEmail(user != null ? user.getEmail() : getEmailFromOAuth()));
        return "private/workspace/list";
    }

    @PostMapping("/create")
    public String createWorkspace(@Valid WorkspaceRequest workspaceRequest, @AuthenticationPrincipal User user, BindingResult result, Model model){

        if(result.hasErrors()){ return createWorkspaceView(workspaceRequest, user, model);}

        workspaceRequest.setOwner(user != null ? user.getId() : userService.findUserByEmail(getEmailFromOAuth()).getId());

        String workspaceId= workspaceService.createWorkspace(workspaceRequest);
        log.info("createWorkspace - workspaceId: "+workspaceId);

        return "redirect:/private/workspace/list";
    }


}
