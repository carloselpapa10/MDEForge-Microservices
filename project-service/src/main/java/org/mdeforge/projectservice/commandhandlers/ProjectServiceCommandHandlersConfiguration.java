package org.mdeforge.projectservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@Configuration
@Import({ SagaParticipantConfiguration.class, TramEventsPublisherConfiguration.class })
public class ProjectServiceCommandHandlersConfiguration {

	@Bean
	public ProjectServiceCommandHandlers projectServiceCommandHandlers() {
	    return new ProjectServiceCommandHandlers();
	}

	@Bean
	public CommandDispatcher commandDispatcher(ProjectServiceCommandHandlers projectServiceCommandHandlers) {
	    return new SagaCommandDispatcher("projectServiceDispatcher", projectServiceCommandHandlers.commandHandlers());
	}
}
