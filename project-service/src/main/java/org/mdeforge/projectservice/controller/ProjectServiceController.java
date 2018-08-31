package org.mdeforge.projectservice.controller;

import org.mdeforge.projectservice.impl.*;
import org.mdeforge.projectservice.model.*;
import org.mdeforge.projectservice.webapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ProjectServiceController {

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceController.class);

	@Autowired
	private ProjectServiceImpl projectServiceImpl;

	@PostMapping("createProject/project")
	public CreateProjectResponse createProject(@RequestBody CreateProjectRequest createProjectRequest){
		log.info("createProject(@RequestBody CreateProjectRequest createProjectRequest) - ProjectServiceController - ProjectService");
		
		/*TODO*/
		return new CreateProjectResponse();
	}
			
	@PutMapping("/updateProject/project")
	public ResponseEntity<Project> updateProject(@RequestBody Project project){
		log.info("updateProject(@RequestBody Project project) - ProjectServiceController - ProjectService");

		/*TODO*/
		return null;
	}
 			
	@GetMapping("/findProject/{projectId}")
	public Project findProject(@RequestParam String id){
		log.info("findProject(String id) - ProjectServiceController - ProjectService");
		
		/*TODO*/
		return null;
	} 			

	@DeleteMapping("/deleteProject/{projectId}")
	public String deleteProject(@RequestParam String id){
		log.info("deleteProject(String id) - ProjectServiceController - ProjectService");

		/*TODO*/
		return null;
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
	public ResponseEntity<Project> shareProjectToUser(@RequestBody Project project){
		log.info("shareProjectToUser(@RequestBody Project project) - ProjectServiceController - ProjectService");

		/*TODO*/
		return null;
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
		return projectServiceImpl.findAll();
	}

}


