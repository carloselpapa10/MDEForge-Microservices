package org.mdeforge.workspaceservice.saga.addprojecttoworkspace;

import org.mdeforge.workspaceservice.impl.*;
import org.mdeforge.workspaceservice.proxy.*;
import org.mdeforge.servicemodel.user.api.commands.*;	
import org.mdeforge.servicemodel.user.api.info.*;
import org.mdeforge.servicemodel.workspace.api.commands.*;	
import org.mdeforge.servicemodel.workspace.api.info.*;
import org.mdeforge.servicemodel.project.api.commands.*;	
import org.mdeforge.servicemodel.project.api.info.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.orchestration.SagaDefinition;
import io.eventuate.tram.sagas.simpledsl.SimpleSaga;

@Component
public class AddProjectToWorkspaceSaga implements SimpleSaga<AddProjectToWorkspaceSagaData>{
	
	private static final Logger log = LoggerFactory.getLogger(AddProjectToWorkspaceSaga.class);

	private SagaDefinition<AddProjectToWorkspaceSagaData> sagaDefinition;
	
	public AddProjectToWorkspaceSaga(UserServiceProxy userService, WorkspaceServiceProxy workspaceService, ProjectServiceProxy projectService){
		
		this.sagaDefinition =
				step()					
					.invokeParticipant(userService.validateUserCommand, this::makeValidateUserCommand)
				.step()
					.invokeParticipant(projectService.validateProjectCommand, this::makeValidateProjectCommand)
				.step()
					.invokeParticipant(workspaceService.addProjectToWorkspaceCommand, this::makeAddProjectToWorkspaceCommand)
				.build();
	}

	@Override
	public SagaDefinition<AddProjectToWorkspaceSagaData> getSagaDefinition() {
		return sagaDefinition;
	}

	private ValidateUserCommand makeValidateUserCommand(AddProjectToWorkspaceSagaData data) {
		log.info("makeValidateUserCommand() - AddProjectToWorkspaceSaga - WorkspaceService"); 
		return new ValidateUserCommand();
	}

	private ValidateProjectCommand makeValidateProjectCommand(AddProjectToWorkspaceSagaData data) {
		log.info("makeValidateProjectCommand() - AddProjectToWorkspaceSaga - WorkspaceService"); 
		return new ValidateProjectCommand();
	}

	private AddProjectToWorkspaceCommand makeAddProjectToWorkspaceCommand(AddProjectToWorkspaceSagaData data) {
		log.info("makeAddProjectToWorkspaceCommand() - AddProjectToWorkspaceSaga - WorkspaceService"); 
		return new AddProjectToWorkspaceCommand();
	}

}
