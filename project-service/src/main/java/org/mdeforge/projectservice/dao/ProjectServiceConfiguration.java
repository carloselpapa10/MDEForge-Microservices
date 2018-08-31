package org.mdeforge.projectservice.dao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import io.eventuate.tram.commands.common.ChannelMapping;
import io.eventuate.tram.commands.common.DefaultChannelMapping;
import io.eventuate.tram.events.publisher.TramEventsPublisherConfiguration;
import io.eventuate.tram.sagas.participant.SagaParticipantConfiguration;
import io.eventuate.tram.sagas.orchestration.SagaManager;
import io.eventuate.tram.sagas.orchestration.SagaManagerImpl;
import io.eventuate.tram.sagas.orchestration.SagaOrchestratorConfiguration;
import org.mdeforge.projectservice.saga.addartifacttoproject.AddArtifactToProjectSaga;
import org.mdeforge.projectservice.saga.addartifacttoproject.AddArtifactToProjectSagaData;
import org.mdeforge.projectservice.saga.adduserinproject.AddUserInProjectSaga;
import org.mdeforge.projectservice.saga.adduserinproject.AddUserInProjectSagaData;

@Configuration
@Import({ SagaParticipantConfiguration.class, TramEventsPublisherConfiguration.class, SagaOrchestratorConfiguration.class })
public class ProjectServiceConfiguration {

	@Bean
	public ChannelMapping channelMapping() {
	    return new DefaultChannelMapping.DefaultChannelMappingBuilder().build();
	}

	@Bean
	public SagaManager<AddArtifactToProjectSagaData> addArtifactToProjectSagaManager(AddArtifactToProjectSaga saga){
		return new SagaManagerImpl<>(saga);
	}

	@Bean
	public SagaManager<AddUserInProjectSagaData> addUserInProjectSagaManager(AddUserInProjectSaga saga){
		return new SagaManagerImpl<>(saga);
	}

}
		
