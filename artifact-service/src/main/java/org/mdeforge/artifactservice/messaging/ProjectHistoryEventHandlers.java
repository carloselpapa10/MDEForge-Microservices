package org.mdeforge.artifactservice.messaging;

import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.project.api.events.*;
import org.mdeforge.artifactservice.impl.*;
import org.mdeforge.artifactservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class ProjectHistoryEventHandlers {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectHistoryEventHandlers.class);

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.projectservice.model.Project")
				.onEvent(ProjectCreatedEvent.class, this::handleProjectCreatedEvent)
				.onEvent(ProjectUpdatedEvent.class, this::handleProjectUpdatedEvent)
				.onEvent(ProjectDeletedEvent.class, this::handleProjectDeletedEvent)
				.onEvent(AddedProjectsToWorkspaceEvent.class, this::handleAddedProjectsToWorkspaceEvent)
				.onEvent(RejectedAddProjectToWorkspaceEvent.class, this::handleRejectedAddProjectToWorkspaceEvent)
				.onEvent(EditedProjectsToWorkspaceCommand.class, this::handleEditedProjectsToWorkspaceCommand)
				.onEvent(RejectedEditProjectsToWorkspaceCommand.class, this::handleRejectedEditProjectsToWorkspaceCommand)
				.onEvent(AddedArtifactToProjectEvent.class, this::handleAddedArtifactToProjectEvent)
				.onEvent(SharedProjectWithUserEvent.class, this::handleSharedProjectWithUserEvent)
				.onEvent(RemovedArtifactFromProjectEvent.class, this::handleRemovedArtifactFromProjectEvent)
				.onEvent(AddedUserInProjectEvent.class, this::handleAddedUserInProjectEvent)
				.onEvent(RemovedUserFromProjectEvent.class, this::handleRemovedUserFromProjectEvent)
				.build();
	}

	private void handleProjectCreatedEvent(DomainEventEnvelope<ProjectCreatedEvent> dee) {
		log.info("handleProjectCreatedEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleProjectUpdatedEvent(DomainEventEnvelope<ProjectUpdatedEvent> dee) {
		log.info("handleProjectUpdatedEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleProjectDeletedEvent(DomainEventEnvelope<ProjectDeletedEvent> dee) {
		log.info("handleProjectDeletedEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleAddedProjectsToWorkspaceEvent(DomainEventEnvelope<AddedProjectsToWorkspaceEvent> dee) {
		log.info("handleAddedProjectsToWorkspaceEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleRejectedAddProjectToWorkspaceEvent(DomainEventEnvelope<RejectedAddProjectToWorkspaceEvent> dee) {
		log.info("handleRejectedAddProjectToWorkspaceEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleEditedProjectsToWorkspaceCommand(DomainEventEnvelope<EditedProjectsToWorkspaceCommand> dee) {
		log.info("handleEditedProjectsToWorkspaceCommand() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleRejectedEditProjectsToWorkspaceCommand(DomainEventEnvelope<RejectedEditProjectsToWorkspaceCommand> dee) {
		log.info("handleRejectedEditProjectsToWorkspaceCommand() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleAddedArtifactToProjectEvent(DomainEventEnvelope<AddedArtifactToProjectEvent> dee) {
		log.info("handleAddedArtifactToProjectEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleSharedProjectWithUserEvent(DomainEventEnvelope<SharedProjectWithUserEvent> dee) {
		log.info("handleSharedProjectWithUserEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleRemovedArtifactFromProjectEvent(DomainEventEnvelope<RemovedArtifactFromProjectEvent> dee) {
		log.info("handleRemovedArtifactFromProjectEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleAddedUserInProjectEvent(DomainEventEnvelope<AddedUserInProjectEvent> dee) {
		log.info("handleAddedUserInProjectEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleRemovedUserFromProjectEvent(DomainEventEnvelope<RemovedUserFromProjectEvent> dee) {
		log.info("handleRemovedUserFromProjectEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

}
