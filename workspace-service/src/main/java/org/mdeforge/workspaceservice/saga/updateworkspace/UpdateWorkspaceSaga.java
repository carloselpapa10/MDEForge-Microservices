package org.mdeforge.workspaceservice.saga.updateworkspace;

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
public class UpdateWorkspaceSaga implements SimpleSaga<UpdateWorkspaceSagaData>{
	
	private static final Logger log = LoggerFactory.getLogger(UpdateWorkspaceSaga.class);

	private SagaDefinition<UpdateWorkspaceSagaData> sagaDefinition;
	
	public UpdateWorkspaceSaga(UserServiceProxy userService, WorkspaceServiceProxy workspaceService, ProjectServiceProxy projectService){
		
		this.sagaDefinition =
				step()					
					.invokeParticipant(userService.validateUserCommand, this::makeValidateUserCommand)
				.step()
					.invokeParticipant(projectService.editProjectsToWorkspaceCommand, this::makeEditProjectsToWorkspaceCommand)
					.onReply(ProjectInfo.class, this::handleEditProjectsToWorkspaceCommand)				
					.withCompensation(projectService.rejectEditProjectsToWorkspaceCommand, this::makeRejectEditProjectsToWorkspaceCommand)			
				.step()
					.invokeParticipant(workspaceService.updateWorkspaceCommand, this::makeUpdateWorkspaceCommand)
				.build();
	}

	@Override
	public SagaDefinition<UpdateWorkspaceSagaData> getSagaDefinition() {
		return sagaDefinition;
	}

	private ValidateUserCommand makeValidateUserCommand(UpdateWorkspaceSagaData data) {
		log.info("makeValidateUserCommand() - UpdateWorkspaceSaga - WorkspaceService"); 
		return new ValidateUserCommand();
	}

	private EditProjectsToWorkspaceCommand makeEditProjectsToWorkspaceCommand(UpdateWorkspaceSagaData data) {
		log.info("makeEditProjectsToWorkspaceCommand() - UpdateWorkspaceSaga - WorkspaceService"); 
		return new EditProjectsToWorkspaceCommand();
	}

	private void handleEditProjectsToWorkspaceCommand(UpdateWorkspaceSagaData data, ProjectInfo projectInfo) {
		log.info("handleEditProjectsToWorkspaceCommand() - UpdateWorkspaceSaga - WorkspaceService"); 
	}

	private RejectEditProjectsToWorkspaceCommand makeRejectEditProjectsToWorkspaceCommand(UpdateWorkspaceSagaData data) {
		log.info("makeRejectEditProjectsToWorkspaceCommand() - UpdateWorkspaceSaga - WorkspaceService"); 
		return new RejectEditProjectsToWorkspaceCommand();
	}

	private UpdateWorkspaceCommand makeUpdateWorkspaceCommand(UpdateWorkspaceSagaData data) {
		log.info("makeUpdateWorkspaceCommand() - UpdateWorkspaceSaga - WorkspaceService"); 
		return new UpdateWorkspaceCommand();
	}

}
