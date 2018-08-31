package org.mdeforge.projectservice.messaging;

import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.artifact.api.events.*;
import org.mdeforge.projectservice.impl.*;
import org.mdeforge.projectservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class ArtifactHistoryEventHandlers {
	
	private static final Logger log = LoggerFactory.getLogger(ArtifactHistoryEventHandlers.class);

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.artifactservice.model.Artifact")
				.onEvent(ArtifactCreatedEvent.class, this::handleArtifactCreatedEvent)
				.onEvent(ArtifactUpdatedEvent.class, this::handleArtifactUpdatedEvent)
				.onEvent(ArtifactDeletedEvent.class, this::handleArtifactDeletedEvent)
				.onEvent(SharedArtifactToUserEvent.class, this::handleSharedArtifactToUserEvent)
				.onEvent(ChangedArtifactOpenEvent.class, this::handleChangedArtifactOpenEvent)
				.onEvent(AddedArtifactToProjectListEvent.class, this::handleAddedArtifactToProjectListEvent)
				.onEvent(RemovedArtifactToProjectListEvent.class, this::handleRemovedArtifactToProjectListEvent)
				.build();
	}

	private void handleArtifactCreatedEvent(DomainEventEnvelope<ArtifactCreatedEvent> dee) {
		log.info("handleArtifactCreatedEvent() - ArtifactHistoryEventHandlers - ArtifactService");
	}

	private void handleArtifactUpdatedEvent(DomainEventEnvelope<ArtifactUpdatedEvent> dee) {
		log.info("handleArtifactUpdatedEvent() - ArtifactHistoryEventHandlers - ArtifactService");
	}

	private void handleArtifactDeletedEvent(DomainEventEnvelope<ArtifactDeletedEvent> dee) {
		log.info("handleArtifactDeletedEvent() - ArtifactHistoryEventHandlers - ArtifactService");
	}

	private void handleSharedArtifactToUserEvent(DomainEventEnvelope<SharedArtifactToUserEvent> dee) {
		log.info("handleSharedArtifactToUserEvent() - ArtifactHistoryEventHandlers - ArtifactService");
	}

	private void handleChangedArtifactOpenEvent(DomainEventEnvelope<ChangedArtifactOpenEvent> dee) {
		log.info("handleChangedArtifactOpenEvent() - ArtifactHistoryEventHandlers - ArtifactService");
	}

	private void handleAddedArtifactToProjectListEvent(DomainEventEnvelope<AddedArtifactToProjectListEvent> dee) {
		log.info("handleAddedArtifactToProjectListEvent() - ArtifactHistoryEventHandlers - ArtifactService");
	}

	private void handleRemovedArtifactToProjectListEvent(DomainEventEnvelope<RemovedArtifactToProjectListEvent> dee) {
		log.info("handleRemovedArtifactToProjectListEvent() - ArtifactHistoryEventHandlers - ArtifactService");
	}

}
