package org.mdeforge.projectservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.project.api.commands.*;
import org.mdeforge.servicemodel.project.api.info.*;
import org.mdeforge.projectservice.impl.*;
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

public class ProjectServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceCommandHandlers.class);

	@Autowired
	private ProjectServiceImpl projectServiceImpl;

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
		/*TODO*/
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
