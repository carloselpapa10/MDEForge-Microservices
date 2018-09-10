package org.mdeforge.projectservice.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;
import io.eventuate.tram.sagas.orchestration.SagaOrchestratorConfiguration;

@Configuration
@Import({ SagaParticipantConfiguration.class, TramEventsPublisherConfiguration.class, SagaOrchestratorConfiguration.class })
public class ProjectServiceConfiguration {

	@Bean
	public ChannelMapping channelMapping() {
	    return new DefaultChannelMapping.DefaultChannelMappingBuilder().build();
	}
}
		
