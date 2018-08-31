package org.mdeforge.userservice.model;

import org.springframework.stereotype.Component;
import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.mdeforge.servicemodel.user.api.events.UserDomainEvent;

@Component
public class UserDomainEventPublisher extends AbstractAggregateDomainEventPublisher<User,UserDomainEvent>{

	public UserDomainEventPublisher(DomainEventPublisher eventPublisher) {
		super(eventPublisher, User.class, User::getId);
    }
}
