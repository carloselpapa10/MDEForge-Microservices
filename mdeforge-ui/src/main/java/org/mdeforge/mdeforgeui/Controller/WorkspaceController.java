package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Project;
import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Model.Workspace;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.mdeforge.mdeforgeui.Service.WorkspaceService;
import org.mdeforge.mdeforgeui.WebApi.ProjectRequest;
import org.mdeforge.mdeforgeui.WebApi.WorkspaceRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.List;


@Controller
@RequestMapping("/private/workspace")
public class WorkspaceController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;

    @GetMapping("/{workspaceId}")
    public String details(Model model, @PathVariable("workspaceId") String workspaceId, @ModelAttribute("currentUser") User user){

        Workspace workspace = workspaceService.findWorkspaceById(workspaceId);
        List<Project> projectList = projectService.findProjectListByUserEmail(user.getEmail());

        workspace.getProjects().forEach(project ->{

            for(int index=0; index < projectList.size(); index++){
                if(projectList.get(index).getId().equals(project.getId())){
                    projectList.remove(projectList.get(index));
                    break;
                }
            }

        });

        model.addAttribute("workspace", workspace);
        model.addAttribute("projectList", projectList);

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
        return "redirect:/private/workspace/list";
    }

    @PostMapping("/{idWorkspace}/addNewProjectToWorkspace")
    public @ResponseBody HttpEntity<Project> addNewProjectInWorkspace(@PathVariable("idWorkspace") String workspaceId, @ModelAttribute ProjectRequest projectRequest, @ModelAttribute("currentUser") User user){

        try{
            projectRequest.setOwner(user.getId() != null ? user.getId() : userService.findUserByEmail(user.getEmail()).getId());

            String projectId = projectService.createProject(projectRequest);

            if(projectId == null){ throw new Exception("ProjectService - Server problems");}
            Project project = projectService.findProjectById(projectId);

            if(workspaceService.addProjectToWorkspace(workspaceId, projectId) != null){
                return  new ResponseEntity<Project>(project, HttpStatus.OK);
            }else{
                throw new Exception("WorkspaceService - Server problems");
            }

        } catch (Exception e){
            return  new ResponseEntity<Project>(HttpStatus.UNPROCESSABLE_ENTITY);
        }

    }

    @GetMapping("/{idWorkspace}/add/{idProject}")
    public @ResponseBody HttpEntity<Project> addProjectInWorkspace2(@PathVariable("idWorkspace") String workspaceId, @PathVariable("idProject") String projectId){
        try{

            Project project = projectService.findProjectById(projectId);
            if(project == null){ throw new Exception("ProjectService - Server problems");}

            Workspace workspace = workspaceService.findWorkspaceById(workspaceId);
            if(workspace == null){ throw new Exception("WorkspaceService - Server problems");}

            if(workspaceService.addProjectToWorkspace(workspaceId, projectId) != null){
                return  new ResponseEntity<Project>(project, HttpStatus.OK);
            }else{
                throw new Exception("WorkspaceService - Server problems");
            }

        } catch (Exception e) {
            return  new ResponseEntity<Project>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{idWorkspace}/remove/{idProject}")
    public @ResponseBody HttpEntity<String> removeProjectFromWorkspace(@PathVariable("idWorkspace") String workspaceId, @PathVariable("idProject") String projectId) {

        try{

            Project project = projectService.findProjectById(projectId);
            if(project == null){ throw new Exception("ProjectService - Server problems");}

            Workspace workspace = workspaceService.findWorkspaceById(workspaceId);
            if(workspace == null){ throw new Exception("WorkspaceService - Server problems");}

            if(workspaceService.removeProjectToWorkspace(workspaceId, projectId) != null){
                return  new ResponseEntity<String>("ok", HttpStatus.OK);
            }else{
                throw new Exception("WorkspaceService - Server problems");
            }

        } catch (Exception e) {
            return  new ResponseEntity<String>("ko", HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/delete")
    public String deleteWorkspace(@RequestParam("id") String workspaceId, Model model){

        Workspace workspace = workspaceService.findWorkspaceById(workspaceId);
        if(workspace==null) return null;

        workspaceService.deleteWorkspace(workspaceId);

        return "redirect:/private/workspace/list";
    }


}
