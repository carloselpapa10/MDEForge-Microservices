package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Project;
import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.mdeforge.mdeforgeui.Service.WorkspaceService;
import org.mdeforge.mdeforgeui.WebApi.ProjectRequest;
import org.mdeforge.mdeforgeui.WebApi.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


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

    @GetMapping("/{workspaceId}")
    public String details(Model model, @PathVariable("workspaceId") String workspaceId, @ModelAttribute("currentUser") User user){

        model.addAttribute("workspace", workspaceService.findWorkspaceById(workspaceId));
        model.addAttribute("projectList", projectService.findProjectListByUserEmail(user.getEmail()));

        return "private/workspace/details";
    }

    @GetMapping("/create")
    public String createWorkspaceView(@ModelAttribute WorkspaceRequest workspaceRequest, @ModelAttribute("currentUser") User user, Model model){

        model.addAttribute("projectList", projectService.findProjectListByUserEmail(user.getEmail()));
        return "private/workspace/insert";
    }

    @GetMapping("/list")
    public String listWorkspaceView(@ModelAttribute("currentUser") User user, Model model){

        model.addAttribute("workspaceList", workspaceService.findWorkspaceListByUserEmail(user.getEmail()));
        return "private/workspace/list";
    }

    @PostMapping("/create")
    public String createWorkspace(@Valid WorkspaceRequest workspaceRequest, @ModelAttribute("currentUser") User user, BindingResult result, Model model){

        if(result.hasErrors()){ return createWorkspaceView(workspaceRequest, user, model);}

        workspaceRequest.setOwner(user.getId() != null ? user.getId() : userService.findUserByEmail(user.getEmail()).getId());

        String workspaceId= workspaceService.createWorkspace(workspaceRequest);
        log.info("createWorkspace - workspaceId: "+workspaceId);

        return "redirect:/private/workspace/list";
    }

    @PostMapping("/{idWorkspace}/addNewProjectToWorkspace")
    public @ResponseBody HttpEntity<Project> addNewProjectToWorkspace(@PathVariable("idWorkspace") String workspaceId, @ModelAttribute ProjectRequest projectRequest, @ModelAttribute("currentUser") User user){


        log.info("addNewProjectToWorkspace");



        /* addProjectToWorkspace */

        try{
            projectRequest.setOwner(user.getId() != null ? user.getId() : userService.findUserByEmail(user.getEmail()).getId());

            String projectId = projectService.createProject(projectRequest);

            if(projectId == null){ throw new Exception("Server problems");}

            workspaceService.addProjectToWorkspace(workspaceId, projectId);

        } catch (Exception e){
            return  new ResponseEntity<Project>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

        /*
        try {
			Project p = workspaceService.addNewProjectInWorkspace(projectName, idWorkspace, user);
			return  new ResponseEntity<Project>(p, HttpStatus.OK);
		} catch (BusinessException e) {
			return  new ResponseEntity<Project>(HttpStatus.UNPROCESSABLE_ENTITY);
		}
        * */

        return null;
    }


}
