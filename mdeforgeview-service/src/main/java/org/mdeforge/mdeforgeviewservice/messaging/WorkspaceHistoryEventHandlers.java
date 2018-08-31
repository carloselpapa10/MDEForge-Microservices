package org.mdeforge.mdeforgeviewservice.messaging;

import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.workspace.api.events.*;
import org.mdeforge.mdeforgeviewservice.impl.*;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;	

@Component
public class WorkspaceHistoryEventHandlers {
	
	private static final Logger log = LoggerFactory.getLogger(WorkspaceHistoryEventHandlers.class);

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.workspaceservice.model.Workspace")
				.onEvent(WorkspaceCreatedEvent.class, this::handleWorkspaceCreatedEvent)
				.onEvent(WorkspaceUpdatedEvent.class, this::handleWorkspaceUpdatedEvent)
				.onEvent(WorkspaceDeletedEvent.class, this::handleWorkspaceDeletedEvent)
				.onEvent(AddedProjectToWorkspaceEvent.class, this::handleAddedProjectToWorkspaceEvent)
				.onEvent(RemovedProjectInWorkspace.class, this::handleRemovedProjectInWorkspace)
				.build();
	}

	private void handleWorkspaceCreatedEvent(DomainEventEnvelope<WorkspaceCreatedEvent> dee) {
		log.info("handleWorkspaceCreatedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");
	}

	private void handleWorkspaceUpdatedEvent(DomainEventEnvelope<WorkspaceUpdatedEvent> dee) {
		log.info("handleWorkspaceUpdatedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");
	}

	private void handleWorkspaceDeletedEvent(DomainEventEnvelope<WorkspaceDeletedEvent> dee) {
		log.info("handleWorkspaceDeletedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");
	}

	private void handleAddedProjectToWorkspaceEvent(DomainEventEnvelope<AddedProjectToWorkspaceEvent> dee) {
		log.info("handleAddedProjectToWorkspaceEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");
	}

	private void handleRemovedProjectInWorkspace(DomainEventEnvelope<RemovedProjectInWorkspace> dee) {
		log.info("handleRemovedProjectInWorkspace() - WorkspaceHistoryEventHandlers - WorkspaceService");
	}

}
