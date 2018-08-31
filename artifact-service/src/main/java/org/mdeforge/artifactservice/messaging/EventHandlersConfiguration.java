package org.mdeforge.artifactservice.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;

@Configuration
public class EventHandlersConfiguration {
			
	@Bean
	public DomainEventDispatcher projectHistoryDomainEventDispatcher(ProjectHistoryEventHandlers projectHistoryEventHandlers, MessageConsumer messageConsumer) {
		return new DomainEventDispatcher("projectHistoryDomainEventDispatcher", projectHistoryEventHandlers.domainEventHandlers(), messageConsumer);
	}

	@Bean
	public DomainEventDispatcher userHistoryDomainEventDispatcher(UserHistoryEventHandlers userHistoryEventHandlers, MessageConsumer messageConsumer) {
		return new DomainEventDispatcher("userHistoryDomainEventDispatcher", userHistoryEventHandlers.domainEventHandlers(), messageConsumer);
	}

}
