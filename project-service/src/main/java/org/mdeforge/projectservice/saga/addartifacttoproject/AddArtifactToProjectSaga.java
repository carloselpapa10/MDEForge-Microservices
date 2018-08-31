package org.mdeforge.projectservice.saga.addartifacttoproject;

import org.mdeforge.projectservice.impl.*;
import org.mdeforge.projectservice.proxy.*;
import org.mdeforge.servicemodel.user.api.commands.*;	
import org.mdeforge.servicemodel.user.api.info.*;
import org.mdeforge.servicemodel.artifact.api.commands.*;	
import org.mdeforge.servicemodel.artifact.api.info.*;
import org.mdeforge.servicemodel.project.api.commands.*;	
import org.mdeforge.servicemodel.project.api.info.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

@Component
public class AddArtifactToProjectSaga implements SimpleSaga<AddArtifactToProjectSagaData>{
	
	private static final Logger log = LoggerFactory.getLogger(AddArtifactToProjectSaga.class);

	private SagaDefinition<AddArtifactToProjectSagaData> sagaDefinition;
	
	public AddArtifactToProjectSaga(UserServiceProxy userService, ArtifactServiceProxy artifactService, ProjectServiceProxy projectService){
		
		this.sagaDefinition =
				step()					
					.invokeParticipant(userService.validateUserCommand, this::makeValidateUserCommand)
				.step()
					.invokeParticipant(artifactService.validateArtifactCommand, this::makeValidateArtifactCommand)
				.step()
					.invokeParticipant(projectService.addArtifactToProjectCommand, this::makeAddArtifactToProjectCommand)
				.build();
	}

	@Override
	public SagaDefinition<AddArtifactToProjectSagaData> getSagaDefinition() {
		return sagaDefinition;
	}

	private ValidateUserCommand makeValidateUserCommand(AddArtifactToProjectSagaData data) {
		log.info("makeValidateUserCommand() - AddArtifactToProjectSaga - ProjectService"); 
		return new ValidateUserCommand();
	}

	private ValidateArtifactCommand makeValidateArtifactCommand(AddArtifactToProjectSagaData data) {
		log.info("makeValidateArtifactCommand() - AddArtifactToProjectSaga - ProjectService"); 
		return new ValidateArtifactCommand();
	}

	private AddArtifactToProjectCommand makeAddArtifactToProjectCommand(AddArtifactToProjectSagaData data) {
		log.info("makeAddArtifactToProjectCommand() - AddArtifactToProjectSaga - ProjectService"); 
		return new AddArtifactToProjectCommand();
	}

}
