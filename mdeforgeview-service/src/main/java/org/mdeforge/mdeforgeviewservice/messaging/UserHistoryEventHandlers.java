package org.mdeforge.mdeforgeviewservice.messaging;

import org.mdeforge.mdeforgeviewservice.dao.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.user.api.events.*;
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
	private UserService userService;

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
											dee.getEvent().getUserInfo().getUsername(),
                                                dee.getEvent().getUserInfo().getState());

		userService.createUser(user);
	}

	private void handleUserUpdatedEvent(DomainEventEnvelope<UserUpdatedEvent> dee) {
		log.info("handleUserUpdatedEvent() - UserHistoryEventHandlers - UserService");

		User user = userService.findUser(dee.getAggregateId());
		user.setEmail(dee.getEvent().getUserInfo().getEmail());
		user.setEnabled(dee.getEvent().getUserInfo().isEnabled());
		user.setFirstname(dee.getEvent().getUserInfo().getFirstname());
		user.setLastname(dee.getEvent().getUserInfo().getLastname());
		user.setImage(dee.getEvent().getUserInfo().getImage());
		user.setState(dee.getEvent().getUserInfo().getState());
		user.setUsername(dee.getEvent().getUserInfo().getUsername());

		userService.updateUser(user);
	}

	private void handleUserDeletedEvent(DomainEventEnvelope<UserDeletedEvent> dee) {
		log.info("handleUserDeletedEvent() - UserHistoryEventHandlers - UserService");

        User user = userService.findUser(dee.getAggregateId());

        userService.deleteUser(user);
	}

}
