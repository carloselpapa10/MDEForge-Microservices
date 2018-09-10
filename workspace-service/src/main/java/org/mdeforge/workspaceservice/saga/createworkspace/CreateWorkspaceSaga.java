package org.mdeforge.workspaceservice.saga.createworkspace;

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

import java.util.ArrayList;
import java.util.List;

@Component
public class CreateWorkspaceSaga implements SimpleSaga<CreateWorkspaceSagaData>{
	
	private static final Logger log = LoggerFactory.getLogger(CreateWorkspaceSaga.class);

	private SagaDefinition<CreateWorkspaceSagaData> sagaDefinition;
	
	public CreateWorkspaceSaga(UserServiceProxy userService, WorkspaceServiceProxy workspaceService, ProjectServiceProxy projectService){
		
		this.sagaDefinition =
				step()					
					.withCompensation(workspaceService.rejectCreateWorkspaceCommand, this::makeRejectCreateWorkspaceCommand)			
				.step()
					.invokeParticipant(userService.validateUserCommand, this::makeValidateUserCommand)
				.step()
                        .invokeParticipant(projectService.validateProjectListCommand, this::makeValidateProjectListCommand)
				.step()
					.invokeParticipant(workspaceService.completeCreateWorkspaceCommand, this::makeCompleteCreateWorkspaceCommand)
				.build();
	}

	@Override
	public SagaDefinition<CreateWorkspaceSagaData> getSagaDefinition() {
		return sagaDefinition;
	}

	private RejectCreateWorkspaceCommand makeRejectCreateWorkspaceCommand(CreateWorkspaceSagaData data) {
		log.info("makeRejectCreateWorkspaceCommand() - CreateWorkspaceSaga - WorkspaceService"); 
		return new RejectCreateWorkspaceCommand(new WorkspaceInfo(data.getWorkspaceId()));
	}

	private ValidateUserCommand makeValidateUserCommand(CreateWorkspaceSagaData data) {
		log.info("makeValidateUserCommand() - CreateWorkspaceSaga - WorkspaceService"); 
		return new ValidateUserCommand(new UserInfo(data.getOwner()));
	}

	private ValidateProjectListCommand makeValidateProjectListCommand(CreateWorkspaceSagaData data) {
		log.info("makeValidateProjectListCommand() - CreateWorkspaceSaga - WorkspaceService");

		List<ProjectInfo>  projectInfoList = new ArrayList<>();
		data.getProjects().forEach(projectId -> {
			projectInfoList.add(new ProjectInfo(projectId));
		});

		return new ValidateProjectListCommand(projectInfoList);
	}

	private void handleAddProjectsToWorkspaceCommand(CreateWorkspaceSagaData data, ProjectInfo projectInfoList) {
		log.info("handleAddProjectsToWorkspaceCommand() - CreateWorkspaceSaga - WorkspaceService");
	}

	private CompleteCreateWorkspaceCommand makeCompleteCreateWorkspaceCommand(CreateWorkspaceSagaData data) {
		log.info("makeCompleteCreateWorkspaceCommand() - CreateWorkspaceSaga - WorkspaceService"); 
		return new CompleteCreateWorkspaceCommand(new WorkspaceInfo(data.getWorkspaceId()));
	}

}
