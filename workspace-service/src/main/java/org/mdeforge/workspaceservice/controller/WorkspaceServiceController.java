package org.mdeforge.workspaceservice.controller;

import org.mdeforge.workspaceservice.dao.*;
import org.mdeforge.workspaceservice.model.*;
import org.mdeforge.workspaceservice.webapi.*;
import org.springframework.beans.factory.annotation.Autowired;
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

	@PostMapping("createWorkspace/workspace")
	public CreateWorkspaceResponse createWorkspace(@RequestBody CreateWorkspaceRequest request){
		log.info("createWorkspace(@RequestBody CreateWorkspaceRequest createWorkspaceRequest) - WorkspaceServiceController - WorkspaceService");

		Workspace workspace = workspaceService.createWorkspace(new Workspace(request.getName(), request.getDescription(), request.getOwner(), request.getProjects()));

		return new CreateWorkspaceResponse(workspace.getId());
	}
			
	@PutMapping("/updateWorkspace/workspace")
	public ResponseEntity<Workspace> updateWorkspace(@RequestBody Workspace workspace){
		log.info("updateWorkspace(@RequestBody Workspace workspace) - WorkspaceServiceController - WorkspaceService");

		/*TODO*/
		return null;
	}
 			
	@GetMapping("/findWorkspace/{workspaceId}")
	public Workspace findWorkspace(@RequestParam String id){
		log.info("findWorkspace(String id) - WorkspaceServiceController - WorkspaceService");

		return workspaceService.findWorkspace(id);
	} 			

	@DeleteMapping("/deleteWorkspace/{workspaceId}")
	public String deleteWorkspace(@RequestParam String id){
		log.info("deleteWorkspace(String id) - WorkspaceServiceController - WorkspaceService");

		/*TODO*/
		return null;
	} 
			
	@PutMapping("/addProjectToWorkspace/workspace")
	public ResponseEntity<Workspace> addProjectToWorkspace(@RequestBody Workspace workspace){
		log.info("addProjectToWorkspace(@RequestBody Workspace workspace) - WorkspaceServiceController - WorkspaceService");

		/*TODO*/
		return null;
	}
 			
	@PutMapping("/removeProjectInWorkspace/workspace")
	public ResponseEntity<Workspace> removeProjectInWorkspace(@RequestBody Workspace workspace){
		log.info("removeProjectInWorkspace(@RequestBody Workspace workspace) - WorkspaceServiceController - WorkspaceService");

		/*TODO*/
		return null;
	}
 			
	@GetMapping("/retrieve/Workspaces")
	public List<Workspace> findAllWorkspaces(){
		/*Auto-Generated*/
		log.info("findAll() - WorkspaceServiceController - WorkspaceService");
		return workspaceService.findAll();
	}

}


