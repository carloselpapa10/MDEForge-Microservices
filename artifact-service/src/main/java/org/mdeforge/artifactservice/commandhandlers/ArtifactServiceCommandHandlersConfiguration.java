package org.mdeforge.artifactservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@Configuration
@Import({ SagaParticipantConfiguration.class, TramEventsPublisherConfiguration.class })
public class ArtifactServiceCommandHandlersConfiguration {

	@Bean
	public ArtifactServiceCommandHandlers artifactServiceCommandHandlers() {
	    return new ArtifactServiceCommandHandlers();
	}

	@Bean
	public CommandDispatcher commandDispatcher(ArtifactServiceCommandHandlers artifactServiceCommandHandlers) {
	    return new SagaCommandDispatcher("artifactServiceDispatcher", artifactServiceCommandHandlers.commandHandlers());
	}
}
