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

	//@Autowired
	//private ArtifactService artifactService;

	@Autowired
    private EcoreMetamodelService ecoreMetamodelService;
				
	@Autowired
	private UserService userService;
				
	@Autowired
	private WorkspaceService workspaceService;
				
	@Autowired
	private ProjectService projectService;

	/*
	@GetMapping("/findArtifact/{artifactId}")
	public Artifact findArtifact(@PathVariable("artifactId") String id){
		log.info("findArtifact(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return artifactService.findArtifact(id);
	}

	@GetMapping("/retrieve/Artifacts")
	public List<Artifact> findAllArtifacts(){

		log.info("findAllArtifacts() - MdeforgeviewServiceController - MdeforgeviewService");
		return artifactService.findAll();
	}*/

	@GetMapping("/retrieve/ecoreMetamodels/{userId}")
    public List<EcoreMetamodel> findAllEcoreMetamodelsByUserId(@PathVariable("userId") String id){
        log.info("findAllEcoreMetamodelsByUserId() - MdeforgeviewServiceController - MdeforgeviewService");

        return ecoreMetamodelService.findAll(userService.findUser(id));
    }

	@GetMapping("/findUser/{userId}")
	public User findUser(@PathVariable("userId") String id){
		log.info("findUser(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return userService.findUser(id);
	}

	@GetMapping("/retrieve/Users")
	public List<User> findAllUsers(){

		log.info("findAllUsers() - MdeforgeviewServiceController - MdeforgeviewService");
		return userService.findAll();
	}

    @GetMapping("/findUserByEmail/{email:.+}")
    public User findUserByEmail(@PathVariable("email") String email){
        log.info("findUserByEmail(String email) - UserServiceController - UserService");
        return userService.findUserByEmail(email);
    }

    @GetMapping("/findUserByUsername/{username:.+}")
    public User findUserByUsername(@PathVariable("username") String username){
        log.info("findUserByEmail(String username) - UserServiceController - UserService");
        return userService.findUserByUsername(username);
    }

	@GetMapping("/findWorkspace/{workspaceId}")
	public Workspace findWorkspace(@PathVariable("workspaceId") String id){
		log.info("findWorkspace(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return workspaceService.findWorkspace(id);
	}

    @GetMapping("/findWorkspaceListByUserEmail/{email:.+}")
    public List<Workspace> findWorkspaceListByUserEmail(@PathVariable("email") String email){
        log.info("findWorkspaceListByUserEmail(String email) - MdeforgeviewServiceController - MdeforgeviewService");
        return workspaceService.findWorkspaceListByUserEmail(email);
    }

    @GetMapping("/retrieve/Workspaces")
	public List<Workspace> findAllWorkspaces(){

		log.info("findAllWorkspaces() - MdeforgeviewServiceController - MdeforgeviewService");
		return workspaceService.findAll();
	}

	@GetMapping("/findProject/{projectId}")
	public Project findProject(@PathVariable("projectId") String id){
		log.info("findProject(String id) - MdeforgeviewServiceController - MdeforgeviewService");
		return projectService.findProject(id);
	}

	@GetMapping("/findProjectListByUserEmail/{email:.+}")
	public List<Project> findProjectListByUserEmail(@PathVariable("email") String email){
		log.info("findProjectListByUserEmail(String email) - MdeforgeviewServiceController - MdeforgeviewService");
		return projectService.findProjectListByUserEmail(email);
	}

	@GetMapping("/retrieve/Projects")
	public List<Project> findAllProjects(){

		log.info("findAllProjects() - MdeforgeviewServiceController - MdeforgeviewService");
		return projectService.findAll();
	}
}
