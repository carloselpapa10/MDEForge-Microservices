package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Project;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/private/project")
public class ProjectController {

    private static final Logger log = LoggerFactory.getLogger(ProjectController.class);

    @Autowired
    private ProjectService projectService;

    @GetMapping("/{id}")
    public @ResponseBody Project getProject(@PathVariable("id") String id){
        log.info("getProject(@PathVariable String "+id+" )");

        return projectService.findProjectById(id);
    }
}
