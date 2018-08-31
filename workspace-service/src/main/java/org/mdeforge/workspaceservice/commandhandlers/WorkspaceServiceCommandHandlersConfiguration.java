package org.mdeforge.workspaceservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@Configuration
@Import({ SagaParticipantConfiguration.class, TramEventsPublisherConfiguration.class })
public class WorkspaceServiceCommandHandlersConfiguration {

	@Bean
	public WorkspaceServiceCommandHandlers workspaceServiceCommandHandlers() {
	    return new WorkspaceServiceCommandHandlers();
	}

	@Bean
	public CommandDispatcher commandDispatcher(WorkspaceServiceCommandHandlers workspaceServiceCommandHandlers) {
	    return new SagaCommandDispatcher("workspaceServiceDispatcher", workspaceServiceCommandHandlers.commandHandlers());
	}
}
