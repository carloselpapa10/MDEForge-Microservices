package org.mdeforge.mdeforgeviewservice.controller;

import org.mdeforge.mdeforgeviewservice.dao.*;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class MdeforgeviewServiceController {

	private static final Logger log = LoggerFactory.getLogger(MdeforgeviewServiceController.class);

	@Autowired
	private ArtifactService artifactService;
				
	@Autowired
	private UserService userService;
				
	@Autowired
	private WorkspaceService workspaceService;
				
	@Autowired
	private ProjectService projectService;
				
	@GetMapping("/findArtifact/{artifactId}")
	public Artifact findArtifact(@RequestParam String id){
		log.info("findArtifact(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return artifactService.findArtifact(id);
	}

	@GetMapping("/retrieve/Artifacts")
	public List<Artifact> findAllArtifacts(){
		/*Auto-Generated*/
		log.info("findAllArtifacts() - MdeforgeviewServiceController - MdeforgeviewService");
		return artifactService.findAll();
	}

	@GetMapping("/findUser/{userId}")
	public User findUser(@RequestParam String id){
		log.info("findUser(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return userService.findUser(id);
	}

	@GetMapping("/retrieve/Users")
	public List<User> findAllUsers(){
		/*Auto-Generated*/
		log.info("findAllUsers() - MdeforgeviewServiceController - MdeforgeviewService");
		return userService.findAll();
	}

	@GetMapping("/findWorkspace/{workspaceId}")
	public Workspace findWorkspace(@RequestParam String id){
		log.info("findWorkspace(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return workspaceService.findWorkspace(id);
	}

	@GetMapping("/retrieve/Workspaces")
	public List<Workspace> findAllWorkspaces(){
		/*Auto-Generated*/
		log.info("findAllWorkspaces() - MdeforgeviewServiceController - MdeforgeviewService");
		return workspaceService.findAll();
	}

	@GetMapping("/findProject/{projectId}")
	public Project findProject(@RequestParam String id){
		log.info("findProject(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return projectService.findProject(id);
	}

	@GetMapping("/retrieve/Projects")
	public List<Project> findAllProjects(){
		/*Auto-Generated*/
		log.info("findAllProjects() - MdeforgeviewServiceController - MdeforgeviewService");
		return projectService.findAll();
	}

}
