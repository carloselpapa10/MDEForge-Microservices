package org.mdeforge.userservice.commandhandlers;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.commands.consumer.CommandDispatcher;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.participant.SagaCommandDispatcher;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;

@Configuration
@Import({ SagaParticipantConfiguration.class, TramEventsPublisherConfiguration.class })
public class UserServiceCommandHandlersConfiguration {

	@Bean
	public UserServiceCommandHandlers userServiceCommandHandlers() {
	    return new UserServiceCommandHandlers();
	}

	@Bean
	public CommandDispatcher commandDispatcher(UserServiceCommandHandlers userServiceCommandHandlers) {
	    return new SagaCommandDispatcher("userServiceDispatcher", userServiceCommandHandlers.commandHandlers());
	}
}
