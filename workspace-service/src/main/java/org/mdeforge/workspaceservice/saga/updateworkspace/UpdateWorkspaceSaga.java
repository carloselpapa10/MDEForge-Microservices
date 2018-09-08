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

import java.util.ArrayList;
import java.util.List;

@Component
public class UpdateWorkspaceSaga implements SimpleSaga<UpdateWorkspaceSagaData>{
	
	private static final Logger log = LoggerFactory.getLogger(UpdateWorkspaceSaga.class);

	private SagaDefinition<UpdateWorkspaceSagaData> sagaDefinition;
	
	public UpdateWorkspaceSaga(UserServiceProxy userService, WorkspaceServiceProxy workspaceService, ProjectServiceProxy projectService){
		
		this.sagaDefinition =
				step()					
					.invokeParticipant(userService.validateUserCommand, this::makeValidateUserCommand)
				.step()
                        .invokeParticipant(projectService.validateProjectListCommand, this::makeValidateProjectListCommand)
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

		return new ValidateUserCommand(new UserInfo(data.getOwner()));
	}

	private ValidateProjectListCommand makeValidateProjectListCommand(UpdateWorkspaceSagaData data) {
		log.info("makeValidateProjectListCommand() - UpdateWorkspaceSaga - WorkspaceService");

        List<ProjectInfo> projectInfoList = new ArrayList<>();
        data.getProjects().forEach(projectId -> {
            projectInfoList.add(new ProjectInfo(projectId));
        });

		return new ValidateProjectListCommand(projectInfoList);
	}

	private UpdateWorkspaceCommand makeUpdateWorkspaceCommand(UpdateWorkspaceSagaData data) {
		log.info("makeUpdateWorkspaceCommand() - UpdateWorkspaceSaga - WorkspaceService");
		
		return new UpdateWorkspaceCommand(new WorkspaceInfo(data.getWorkspaceId()));
	}

}
