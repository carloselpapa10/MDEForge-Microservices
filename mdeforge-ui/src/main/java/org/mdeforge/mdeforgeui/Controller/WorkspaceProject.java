package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Workspace;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private/workspace")
public class WorkspaceProject {

    @GetMapping("/create")
    public String createWorkspaceView(@ModelAttribute Workspace workspace){
        return "private/workspace/insert";
    }

    @GetMapping("/list")
    public String listWorkspaceView(){
        return "private/workspace/list";
    }


}
