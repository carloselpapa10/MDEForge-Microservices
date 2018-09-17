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

import java.util.ArrayList;
import java.util.List;

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

        List<Role> roleList = new ArrayList<>();
        dee.getEvent().getUserInfo().getRolesInfo().forEach(roleInfo -> {
            roleList.add(new Role(roleInfo.getId(), roleInfo.getName()));
        });

		User user = new User(dee.getAggregateId(),
								dee.getEvent().getUserInfo().getFirstname(),
									dee.getEvent().getUserInfo().getLastname(),
										dee.getEvent().getUserInfo().getEmail(),
											dee.getEvent().getUserInfo().getUsername(),
                                                dee.getEvent().getUserInfo().getState(),
                                                    dee.getEvent().getUserInfo().getPassword(),
                                                        roleList.size() > 0 ? roleList : null,
                                                            dee.getEvent().getUserInfo().getImage());

		userService.createUser(user);
	}

	private void handleUserUpdatedEvent(DomainEventEnvelope<UserUpdatedEvent> dee) {
		log.info("handleUserUpdatedEvent() - UserHistoryEventHandlers - UserService");

		User user = userService.findUser(dee.getAggregateId());

        user.setFirstname(dee.getEvent().getUserInfo().getFirstname());
        user.setLastname(dee.getEvent().getUserInfo().getLastname());
        user.setEmail(dee.getEvent().getUserInfo().getEmail());
        user.setUsername(dee.getEvent().getUserInfo().getUsername());
        user.setEnabled(dee.getEvent().getUserInfo().isEnabled());
		user.setImage(dee.getEvent().getUserInfo().getImage());
		user.setState(dee.getEvent().getUserInfo().getState());
        user.setPassword(dee.getEvent().getUserInfo().getPassword());

        List<Role> roleList = new ArrayList<>();
        dee.getEvent().getUserInfo().getRolesInfo().forEach(roleInfo -> {
            roleList.add(new Role(roleInfo.getId(), roleInfo.getName()));
        });

        user.setRoles(roleList);

		userService.updateUser(user);
	}

	private void handleUserDeletedEvent(DomainEventEnvelope<UserDeletedEvent> dee) {
		log.info("handleUserDeletedEvent() - UserHistoryEventHandlers - UserService");

        User user = userService.findUser(dee.getAggregateId());

        userService.deleteUser(user);
	}

}
