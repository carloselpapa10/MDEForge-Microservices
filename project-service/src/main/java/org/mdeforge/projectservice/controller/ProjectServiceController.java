package org.mdeforge.projectservice.controller;

import org.mdeforge.projectservice.dao.ProjectService;
import org.mdeforge.projectservice.model.*;
import org.mdeforge.projectservice.webapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ProjectServiceController {

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceController.class);

	@Autowired
	private ProjectService projectService;

	@PostMapping("createProject/project")
	public CreateProjectResponse createProject(@RequestBody CreateProjectRequest request){
		log.info("createProject(@RequestBody CreateProjectRequest createProjectRequest) - ProjectServiceController - ProjectService");

		Project project = projectService.createProject(new Project(request.getName(), request.getDescription(), request.getOwner()));
		return new CreateProjectResponse(project.getId());
	}
			
	@PutMapping("/updateProject/project")
	public ResponseEntity<Project> updateProject(@RequestBody Project request){
		log.info("updateProject(@RequestBody Project project) - ProjectServiceController - ProjectService");

		Project project = projectService.updateProject(request);
		return project != null ? ResponseEntity.ok(project) : ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
 			
	@GetMapping("/findProject/{projectId}")
	public Project findProject(@RequestParam String id){
		log.info("findProject(String id) - ProjectServiceController - ProjectService");

		return projectService.findProject(id);
	} 			

	@DeleteMapping("/deleteProject/{projectId}")
	public String deleteProject(@RequestParam String id){
		log.info("deleteProject(String id) - ProjectServiceController - ProjectService");

		Project project = projectService.findProject(id);

		if(project!=null){
		    projectService.deleteProject(project);
		    return "Project is being deleted!";
        }
		return "Project ID does not exist!";
	} 
			
	@PutMapping("/addArtifactToProject/project")
	public ResponseEntity<Project> addArtifactToProject(@RequestBody Project project){
		log.info("addArtifactToProject(@RequestBody Project project) - ProjectServiceController - ProjectService");

		/*TODO*/
		return null;
	}
 			
	@PutMapping("/removeArtifactFromProject/project")
	public ResponseEntity<Project> removeArtifactFromProject(@RequestBody Project project){
		log.info("removeArtifactFromProject(@RequestBody Project project) - ProjectServiceController - ProjectService");

		/*TODO*/
		return null;
	}
 			
	@PutMapping("/shareProjectToUser/project")
	public ResponseEntity<Project> shareProjectToUser(@RequestParam String projectId, @RequestParam String userId){
		log.info("shareProjectToUser(@RequestBody Project project) - ProjectServiceController - ProjectService");

		Project project = projectService.findProject(projectId);
		if(project != null){

			project = projectService.shareProjectToUser(project, userId);
			return ResponseEntity.ok(project);
		}

		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	}
 			
	@PutMapping("/addUserInProject/project")
	public ResponseEntity<Project> addUserInProject(@RequestBody Project project){
		log.info("addUserInProject(@RequestBody Project project) - ProjectServiceController - ProjectService");

		/*TODO*/
		return null;
	}
 			
	@PutMapping("/removeUserFromProject/project")
	public ResponseEntity<Project> removeUserFromProject(@RequestBody Project project){
		log.info("removeUserFromProject(@RequestBody Project project) - ProjectServiceController - ProjectService");

		/*TODO*/
		return null;
	}
 			
	@GetMapping("/retrieve/Projects")
	public List<Project> findAllProjects(){
		/*Auto-Generated*/
		log.info("findAll() - ProjectServiceController - ProjectService");
		return projectService.findAll();
	}

}


