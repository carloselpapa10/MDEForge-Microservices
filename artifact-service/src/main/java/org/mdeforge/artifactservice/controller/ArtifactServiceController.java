package org.mdeforge.artifactservice.controller;

import org.mdeforge.artifactservice.impl.*;
import org.mdeforge.artifactservice.model.*;
import org.mdeforge.artifactservice.webapi.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
public class ArtifactServiceController {

	private static final Logger log = LoggerFactory.getLogger(ArtifactServiceController.class);

	@Autowired
	private ArtifactServiceImpl artifactServiceImpl;

	@PostMapping("createArtifact/artifact")
	public CreateArtifactResponse createArtifact(@RequestBody CreateArtifactRequest createArtifactRequest){
		log.info("createArtifact(@RequestBody CreateArtifactRequest createArtifactRequest) - ArtifactServiceController - ArtifactService");
		
		/*TODO*/
		return new CreateArtifactResponse();
	}
			
	@PutMapping("/updateArtifact/artifact")
	public ResponseEntity<Artifact> updateArtifact(@RequestBody Artifact artifact){
		log.info("updateArtifact(@RequestBody Artifact artifact) - ArtifactServiceController - ArtifactService");

		/*TODO*/
		return null;
	}
 			
	@GetMapping("/findArtifact/{artifactId}")
	public Artifact findArtifact(@RequestParam String id){
		log.info("findArtifact(String id) - ArtifactServiceController - ArtifactService");
		
		/*TODO*/
		return null;
	} 			

	@DeleteMapping("/deleteArtifact/{artifactId}")
	public String deleteArtifact(@RequestParam String id){
		log.info("deleteArtifact(String id) - ArtifactServiceController - ArtifactService");

		/*TODO*/
		return null;
	} 
			
	@PutMapping("/shareArtifactToUser/artifact")
	public ResponseEntity<Artifact> shareArtifactToUser(@RequestBody Artifact artifact){
		log.info("shareArtifactToUser(@RequestBody Artifact artifact) - ArtifactServiceController - ArtifactService");

		/*TODO*/
		return null;
	}
 			
	@PutMapping("/changeArtifactOpen/artifact")
	public ResponseEntity<Artifact> changeArtifactOpen(@RequestBody Artifact artifact){
		log.info("changeArtifactOpen(@RequestBody Artifact artifact) - ArtifactServiceController - ArtifactService");

		/*TODO*/
		return null;
	}
 			
	@GetMapping("/retrieve/Artifacts")
	public List<Artifact> findAllArtifacts(){
		/*Auto-Generated*/
		log.info("findAll() - ArtifactServiceController - ArtifactService");
		return artifactServiceImpl.findAll();
	}

}


