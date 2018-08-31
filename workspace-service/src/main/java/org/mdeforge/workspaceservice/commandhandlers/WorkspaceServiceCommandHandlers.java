package org.mdeforge.workspaceservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.workspace.api.commands.*;
import org.mdeforge.servicemodel.workspace.api.info.*;
import org.mdeforge.workspaceservice.impl.*;
import org.mdeforge.workspaceservice.model.*;
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

public class WorkspaceServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceCommandHandlers.class);

	@Autowired
	private WorkspaceServiceImpl workspaceServiceImpl;

	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.WORKSPACESERVICE)
				.onMessage(RejectCreateWorkspaceCommand.class, this::handleRejectCreateWorkspaceCommand)
				.onMessage(CompleteCreateWorkspaceCommand.class, this::handleCompleteCreateWorkspaceCommand)
				.onMessage(UpdateWorkspaceCommand.class, this::handleUpdateWorkspaceCommand)
				.onMessage(AddProjectToWorkspaceCommand.class, this::handleAddProjectToWorkspaceCommand)
				.build();
	}		
		
	private Message handleRejectCreateWorkspaceCommand(CommandMessage<RejectCreateWorkspaceCommand> cm) {
		log.info("handleRejectCreateWorkspaceCommand() - WorkspaceServiceCommandHandlers - WorkspaceService");
		
		RejectCreateWorkspaceCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleCompleteCreateWorkspaceCommand(CommandMessage<CompleteCreateWorkspaceCommand> cm) {
		log.info("handleCompleteCreateWorkspaceCommand() - WorkspaceServiceCommandHandlers - WorkspaceService");
		
		CompleteCreateWorkspaceCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleUpdateWorkspaceCommand(CommandMessage<UpdateWorkspaceCommand> cm) {
		log.info("handleUpdateWorkspaceCommand() - WorkspaceServiceCommandHandlers - WorkspaceService");
		
		UpdateWorkspaceCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleAddProjectToWorkspaceCommand(CommandMessage<AddProjectToWorkspaceCommand> cm) {
		log.info("handleAddProjectToWorkspaceCommand() - WorkspaceServiceCommandHandlers - WorkspaceService");
		
		AddProjectToWorkspaceCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

}
