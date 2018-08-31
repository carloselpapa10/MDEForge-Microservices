package org.mdeforge.projectservice.messaging;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import io.eventuate.tram.events.subscriber.DomainEventDispatcher;
import io.eventuate.tram.messaging.consumer.MessageConsumer;

@Configuration
public class EventHandlersConfiguration {
			
	@Bean
	public DomainEventDispatcher workspaceHistoryDomainEventDispatcher(WorkspaceHistoryEventHandlers workspaceHistoryEventHandlers, MessageConsumer messageConsumer) {
		return new DomainEventDispatcher("workspaceHistoryDomainEventDispatcher", workspaceHistoryEventHandlers.domainEventHandlers(), messageConsumer);
	}

	@Bean
	public DomainEventDispatcher artifactHistoryDomainEventDispatcher(ArtifactHistoryEventHandlers artifactHistoryEventHandlers, MessageConsumer messageConsumer) {
		return new DomainEventDispatcher("artifactHistoryDomainEventDispatcher", artifactHistoryEventHandlers.domainEventHandlers(), messageConsumer);
	}

	@Bean
	public DomainEventDispatcher userHistoryDomainEventDispatcher(UserHistoryEventHandlers userHistoryEventHandlers, MessageConsumer messageConsumer) {
		return new DomainEventDispatcher("userHistoryDomainEventDispatcher", userHistoryEventHandlers.domainEventHandlers(), messageConsumer);
	}

}
