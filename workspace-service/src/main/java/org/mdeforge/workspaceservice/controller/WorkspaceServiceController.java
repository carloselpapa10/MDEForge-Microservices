package org.mdeforge.workspaceservice.controller;

import org.mdeforge.workspaceservice.dao.*;
import org.mdeforge.workspaceservice.model.*;
import org.mdeforge.workspaceservice.webapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class WorkspaceServiceController {

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceController.class);

	@Autowired
	private WorkspaceService workspaceService;

	@PostMapping("/createWorkspace/workspace")
	public CreateWorkspaceResponse createWorkspace(@RequestBody CreateWorkspaceRequest request){
		log.info("createWorkspace(@RequestBody CreateWorkspaceRequest createWorkspaceRequest) - WorkspaceServiceController - WorkspaceService");

		Workspace workspace = workspaceService.createWorkspace(new Workspace(request.getName(), request.getDescription(), request.getOwner(), request.getProjects()));

		return new CreateWorkspaceResponse(workspace.getId());
	}
			
	@PutMapping("/updateWorkspace/workspace")
	public ResponseEntity<Workspace> updateWorkspace(@RequestBody Workspace request){
		log.info("updateWorkspace(@RequestBody Workspace workspace) - WorkspaceServiceController - WorkspaceService");

		Workspace workspace = workspaceService.updateWorkspace(request);
		return workspace != null ? ResponseEntity.ok(workspace) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
 			
	@GetMapping("/findWorkspace/{workspaceId}")
	public Workspace findWorkspace(@PathVariable("workspaceId") String id){
		log.info("findWorkspace(String id) - WorkspaceServiceController - WorkspaceService");

		return workspaceService.findWorkspace(id);
	} 			

	@DeleteMapping("/deleteWorkspace/{workspaceId}")
	public String deleteWorkspace(@PathVariable("workspaceId") String id){
		log.info("deleteWorkspace(String id) - WorkspaceServiceController - WorkspaceService");

		Workspace workspace = workspaceService.findWorkspace(id);
		if(workspace != null){
		    workspaceService.deleteWorkspace(workspace);
		    return "Workspace is being deleted.";
        }

        return "Workspace ID does not exist!";
	} 
			
	@GetMapping("/addProjectToWorkspace/workspace")
	public String addProjectToWorkspace(@RequestParam String workspaceId, @RequestParam String projectId){
		log.info("addProjectToWorkspace(@RequestParam String workspaceId, @RequestParam String projectId) - WorkspaceServiceController - WorkspaceService");

		Workspace workspace = workspaceService.findWorkspace(workspaceId);

		if(workspace!=null){
            workspace = workspaceService.addProjectToWorkspace(workspace, projectId);
            return workspace.getId();
        }
		return null;
	}
 			
	@GetMapping("/removeProjectInWorkspace/workspace")
	public String removeProjectInWorkspace(@RequestParam String workspaceId, @RequestParam String projectId){
		log.info("removeProjectInWorkspace(@RequestParam String workspaceId, @RequestParam String projectId) - WorkspaceServiceController - WorkspaceService");

		Workspace workspace = workspaceService.findWorkspace(workspaceId);

        if(workspace!=null){
            workspace = workspaceService.removeProjectInWorkspace(workspace, projectId);
            return workspace.getId();
        }
        return null;
	}

    @GetMapping("/removeProjectInAllWorkspaces/{projectId}")
    public String removeProjectInAllWorkspaces(@PathVariable("projectId") String projectId){
        log.info("removeProjectInAllWorkspaces(@PathVariable String projectId) - WorkspaceServiceController - WorkspaceService");

        workspaceService.removeProjectInAllWorkspaces(projectId);

        return "Ok";
    }

	@GetMapping("/retrieve/Workspaces")
	public List<Workspace> findAllWorkspaces(){
		/*Auto-Generated*/
		log.info("findAll() - WorkspaceServiceController - WorkspaceService");
		return workspaceService.findAll();
	}

}


