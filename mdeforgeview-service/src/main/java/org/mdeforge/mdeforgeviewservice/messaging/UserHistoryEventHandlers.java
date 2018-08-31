package org.mdeforge.mdeforgeviewservice.messaging;

import org.mdeforge.mdeforgeviewservice.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.user.api.events.*;
import org.mdeforge.mdeforgeviewservice.impl.*;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;	

@Component
public class UserHistoryEventHandlers {
	
	private static final Logger log = LoggerFactory.getLogger(UserHistoryEventHandlers.class);

	@Autowired
	private UserRepository userRepository;

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

		User user = new User(dee.getAggregateId(),
								dee.getEvent().getUserInfo().getFirstname(),
									dee.getEvent().getUserInfo().getLastname(),
										dee.getEvent().getUserInfo().getEmail(),
											dee.getEvent().getUserInfo().getUsername());

		userRepository.save(user);
	}

	private void handleUserUpdatedEvent(DomainEventEnvelope<UserUpdatedEvent> dee) {
		log.info("handleUserUpdatedEvent() - UserHistoryEventHandlers - UserService");
	}

	private void handleUserDeletedEvent(DomainEventEnvelope<UserDeletedEvent> dee) {
		log.info("handleUserDeletedEvent() - UserHistoryEventHandlers - UserService");
	}

}
