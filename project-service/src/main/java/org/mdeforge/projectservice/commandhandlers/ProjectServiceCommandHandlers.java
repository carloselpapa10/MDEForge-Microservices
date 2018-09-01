package org.mdeforge.projectservice.commandhandlers;

import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.project.api.commands.*;
import org.mdeforge.servicemodel.project.api.info.*;
import org.mdeforge.servicemodel.project.api.events.*;
import org.mdeforge.projectservice.dao.*;
import org.mdeforge.projectservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;
import java.util.ArrayList;
import java.util.List;
import static java.util.Collections.singletonList;

public class ProjectServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceCommandHandlers.class);

	@Autowired
	private ProjectService projectService;

	@Autowired
	private ProjectDomainEventPublisher projectDomainEventPublisher;

	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.PROJECTSERVICE)
				.onMessage(AddProjectsToWorkspaceCommand.class, this::handleAddProjectsToWorkspaceCommand)
				.onMessage(RejectAddProjectsToWorkspaceCommand.class, this::handleRejectAddProjectsToWorkspaceCommand)
				.onMessage(EditProjectsToWorkspaceCommand.class, this::handleEditProjectsToWorkspaceCommand)
				.onMessage(RejectEditProjectsToWorkspaceCommand.class, this::handleRejectEditProjectsToWorkspaceCommand)
				.onMessage(ValidateProjectCommand.class, this::handleValidateProjectCommand)
				.onMessage(AddArtifactToProjectCommand.class, this::handleAddArtifactToProjectCommand)
				.onMessage(CompleteAddUserInProjectCommand.class, this::handleCompleteAddUserInProjectCommand)
				.build();
	}		
		
	private Message handleAddProjectsToWorkspaceCommand(CommandMessage<AddProjectsToWorkspaceCommand> cm) {
		log.info("handleAddProjectsToWorkspaceCommand() - ProjectServiceCommandHandlers - ProjectService");
		
		AddProjectsToWorkspaceCommand command = cm.getCommand();

		/*validate projectsId*/
		List<Project> projectList = new ArrayList<>();

		for (ProjectInfo projectInfo : command.getProjectInfoList()){
			Project project = projectService.findProject(projectInfo.getId());
			if(project!= null){
				projectList.add(project);
			}else {
				return withFailure(); /* return withFailure if at least one projectId does not exist .*/
			}
		}

		/*fill projectids to publish an event*/
		List<ProjectInfo>  projectInfoList = new ArrayList<>();
		projectList.forEach(projectId -> {
			projectInfoList.add(new ProjectInfo(projectId.getId()));
		});

		/*because publishing an event - whatever id in this case*/
		Project p = new Project(projectList.get(0).getId());

		List<ProjectDomainEvent> events = singletonList(new AddedProjectsToWorkspaceEvent(projectInfoList, command.getWorkspaceId()));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(p, events);

		/*add Workspace to projects*/
		projectList.forEach(project -> {
			if(!project.getWorkspacelist().contains(command.getWorkspaceId())){
				project.addWorkspacelist(command.getWorkspaceId());
				projectService.saveProject(project);
			}
		});

		projectDomainEventPublisher.publish(p, projectAndEvents.events);

		return withSuccess(new ProjectInfo());
	}

	private Message handleRejectAddProjectsToWorkspaceCommand(CommandMessage<RejectAddProjectsToWorkspaceCommand> cm) {
		log.info("handleRejectAddProjectsToWorkspaceCommand() - ProjectServiceCommandHandlers - ProjectService");
		
		RejectAddProjectsToWorkspaceCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleEditProjectsToWorkspaceCommand(CommandMessage<EditProjectsToWorkspaceCommand> cm) {
		log.info("handleEditProjectsToWorkspaceCommand() - ProjectServiceCommandHandlers - ProjectService");
		
		EditProjectsToWorkspaceCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess(new ProjectInfo());
	}

	private Message handleRejectEditProjectsToWorkspaceCommand(CommandMessage<RejectEditProjectsToWorkspaceCommand> cm) {
		log.info("handleRejectEditProjectsToWorkspaceCommand() - ProjectServiceCommandHandlers - ProjectService");
		
		RejectEditProjectsToWorkspaceCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleValidateProjectCommand(CommandMessage<ValidateProjectCommand> cm) {
		log.info("handleValidateProjectCommand() - ProjectServiceCommandHandlers - ProjectService");
		
		ValidateProjectCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleAddArtifactToProjectCommand(CommandMessage<AddArtifactToProjectCommand> cm) {
		log.info("handleAddArtifactToProjectCommand() - ProjectServiceCommandHandlers - ProjectService");
		
		AddArtifactToProjectCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleCompleteAddUserInProjectCommand(CommandMessage<CompleteAddUserInProjectCommand> cm) {
		log.info("handleCompleteAddUserInProjectCommand() - ProjectServiceCommandHandlers - ProjectService");
		
		CompleteAddUserInProjectCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

}
