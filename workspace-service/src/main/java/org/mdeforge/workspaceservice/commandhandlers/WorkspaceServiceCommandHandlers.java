package org.mdeforge.workspaceservice.commandhandlers;

import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;
import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.workspace.api.commands.*;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCreationCompletedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceCreationRejectedEvent;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceDomainEvent;
import org.mdeforge.servicemodel.workspace.api.info.*;
import org.mdeforge.workspaceservice.dao.*;
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
import static java.util.Collections.singletonList;

public class WorkspaceServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceCommandHandlers.class);

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private WorkspaceDomainEventPublisher workspaceDomainEventPublisher;

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

		Workspace workspace = workspaceService.findWorkspace(command.getWorkspaceInfo().getId());
		workspace.setState(WorkspaceState.REJECTED);

		log.info("workspace rejected successfully - workspaceId: "+workspace.getId());

        WorkspaceInfo workspaceInfo = new WorkspaceInfo(workspace.getId());
        workspaceInfo.setState(workspace.getState().toString());

		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceCreationRejectedEvent(workspaceInfo));
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace,events);

		workspaceService.saveWorkspace(workspace);
		workspaceDomainEventPublisher.publish(workspace, workspaceAndEvents.events);

		return withSuccess();
	}

	private Message handleCompleteCreateWorkspaceCommand(CommandMessage<CompleteCreateWorkspaceCommand> cm) {
		log.info("handleCompleteCreateWorkspaceCommand() - WorkspaceServiceCommandHandlers - WorkspaceService");
		
		CompleteCreateWorkspaceCommand command = cm.getCommand();
		Workspace workspace = workspaceService.findWorkspace(command.getWorkspaceInfo().getId());
		workspace.setState(WorkspaceState.CREATION_COMPLETED);

		log.info("workspace completed successfully - workspaceId: "+workspace.getId());

        WorkspaceInfo workspaceInfo = new WorkspaceInfo(workspace.getId());
        workspaceInfo.setState(workspace.getState().toString());

		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceCreationCompletedEvent(workspaceInfo));
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace,events);

		workspaceService.saveWorkspace(workspace);
		workspaceDomainEventPublisher.publish(workspace, workspaceAndEvents.events);

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
