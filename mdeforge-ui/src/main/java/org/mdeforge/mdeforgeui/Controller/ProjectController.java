package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Project;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.mdeforge.mdeforgeui.Service.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Controller
@RequestMapping("/private/project")
public class ProjectController {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @Autowired
    private WorkspaceService workspaceService;

    @GetMapping("/{id}")
    public @ResponseBody Project getProject(@PathVariable("id") String id){
        log.info("getProject(@PathVariable String "+id+" )");

        return projectService.findProjectById(id);
    }

    @GetMapping("/delete/{projectId}")
    public @ResponseBody String delete(@PathVariable("projectId") String projectId){
        log.info("delete(@RequestParam String "+projectId+")");

        Project project = projectService.findProjectById(projectId);
        if(project == null){return null;}

        log.info(workspaceService.removeProjectInAllWorkspaces(projectId));

        log.info(projectService.deleteProject(projectId));
        return "OK";
    }
}
