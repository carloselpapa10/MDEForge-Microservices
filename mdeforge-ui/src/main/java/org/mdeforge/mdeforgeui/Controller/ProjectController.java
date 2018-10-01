package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Project;
import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.mdeforge.mdeforgeui.Service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/private/project")
public class ProjectController {

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkspaceService workspaceService;

    @Autowired
    private UserService userService;

    @GetMapping("/{id}")
    public @ResponseBody Project getProject(@PathVariable("id") String id){
        return projectService.findProjectById(id);
    }

    @GetMapping("/delete/{projectId}")
    public @ResponseBody String delete(@PathVariable("projectId") String projectId){

        Project project = projectService.findProjectById(projectId);
        if(project == null){return null;}

        workspaceService.removeProjectInAllWorkspaces(projectId);
        projectService.deleteProject(projectId);
        return "OK";
    }

    @GetMapping("/{idProject}/addUser/{idUser}")
    public @ResponseBody
    HttpEntity<User> addUserInProject(@PathVariable("idProject") String projectId, @PathVariable("idUser") String userId) {

        try{

            User user = userService.findUserById(userId);
            if(user== null){return null;}

            Project project = projectService.findProjectById(projectId);
            if(project == null){return null;}

            for(int index = 0; index < project.getUserlist().size(); index++){
                if(project.getUserlist().get(index).getId().equals(userId)){
                    return  new ResponseEntity<User>(HttpStatus.BAD_REQUEST);
                }
            }

           if(projectService.addUserInProject(project.getId(), user.getId()) != null){
               return new ResponseEntity<User>(user, HttpStatus.OK);
           }else{
               throw new Exception("ProjectService - Server problems");
           }

        } catch (Exception e) {
            return  new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }

    @GetMapping("/{idProject}/removeUser/{idUser}")
    public @ResponseBody
    HttpEntity<User> removeUserInProject(@PathVariable("idProject") String projectId, @PathVariable("idUser") String userId) {

        try{

            User user = userService.findUserById(userId);
            if(user== null){return null;}

            Project project = projectService.findProjectById(projectId);
            if(project == null){return null;}

           if(projectService.removeUserFromProject(project.getId(), user.getId()) != null){
               return new ResponseEntity<User>(user, HttpStatus.OK);
           }else{
               throw new Exception("ProjectService - Server problems");
           }

        } catch (Exception e) {
            return  new ResponseEntity<User>(HttpStatus.UNPROCESSABLE_ENTITY);
        }
    }
}
