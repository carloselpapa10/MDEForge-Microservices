package org.mdeforge.projectservice.saga.adduserinproject;

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
public class AddUserInProjectSaga implements SimpleSaga<AddUserInProjectSagaData>{
	
	private static final Logger log = LoggerFactory.getLogger(AddUserInProjectSaga.class);

	private SagaDefinition<AddUserInProjectSagaData> sagaDefinition;
	
	public AddUserInProjectSaga(UserServiceProxy userService, ArtifactServiceProxy artifactService, ProjectServiceProxy projectService){
		
		this.sagaDefinition =
				step()					
					.invokeParticipant(userService.validateUserCommand, this::makeValidateUserCommand)
				.step()
					.invokeParticipant(userService.validateUserListCommand, this::makeValidateUserListCommand)
				.step()
					.invokeParticipant(projectService.completeAddUserInProjectCommand, this::makeCompleteAddUserInProjectCommand)
				.build();
	}

	@Override
	public SagaDefinition<AddUserInProjectSagaData> getSagaDefinition() {
		return sagaDefinition;
	}

	private ValidateUserCommand makeValidateUserCommand(AddUserInProjectSagaData data) {
		log.info("makeValidateUserCommand() - AddUserInProjectSaga - ProjectService"); 
		return new ValidateUserCommand();
	}

	private ValidateUserListCommand makeValidateUserListCommand(AddUserInProjectSagaData data) {
		log.info("makeValidateUserListCommand() - AddUserInProjectSaga - ProjectService"); 
		return new ValidateUserListCommand();
	}

	private CompleteAddUserInProjectCommand makeCompleteAddUserInProjectCommand(AddUserInProjectSagaData data) {
		log.info("makeCompleteAddUserInProjectCommand() - AddUserInProjectSaga - ProjectService"); 
		return new CompleteAddUserInProjectCommand();
	}

}
