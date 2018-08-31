package org.mdeforge.artifactservice.messaging;

import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.user.api.events.*;
import org.mdeforge.artifactservice.impl.*;
import org.mdeforge.artifactservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

@Component
public class UserHistoryEventHandlers {
	
	private static final Logger log = LoggerFactory.getLogger(UserHistoryEventHandlers.class);

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.userservice.model.User")
				.onEvent(UserCreatedEvent.class, this::handleUserCreatedEvent)
				.onEvent(UserUpdatedEvent.class, this::handleUserUpdatedEvent)
				.onEvent(UserDeletedEvent.class, this::handleUserDeletedEvent)
				.build();
	}

	private void handleUserCreatedEvent(DomainEventEnvelope<UserCreatedEvent> dee) {
		log.info("handleUserCreatedEvent() - UserHistoryEventHandlers - UserService");
	}

	private void handleUserUpdatedEvent(DomainEventEnvelope<UserUpdatedEvent> dee) {
		log.info("handleUserUpdatedEvent() - UserHistoryEventHandlers - UserService");
	}

	private void handleUserDeletedEvent(DomainEventEnvelope<UserDeletedEvent> dee) {
		log.info("handleUserDeletedEvent() - UserHistoryEventHandlers - UserService");
	}

}
