package org.mdeforge.workspaceservice.dao;

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
import org.mdeforge.workspaceservice.saga.createworkspace.CreateWorkspaceSaga;
import org.mdeforge.workspaceservice.saga.createworkspace.CreateWorkspaceSagaData;
import org.mdeforge.workspaceservice.saga.updateworkspace.UpdateWorkspaceSaga;
import org.mdeforge.workspaceservice.saga.updateworkspace.UpdateWorkspaceSagaData;
import org.mdeforge.workspaceservice.saga.addprojecttoworkspace.AddProjectToWorkspaceSaga;
import org.mdeforge.workspaceservice.saga.addprojecttoworkspace.AddProjectToWorkspaceSagaData;

@Configuration
@Import({ SagaParticipantConfiguration.class, TramEventsPublisherConfiguration.class, SagaOrchestratorConfiguration.class })
public class WorkspaceServiceConfiguration {

	@Bean
	public ChannelMapping channelMapping() {
	    return new DefaultChannelMapping.DefaultChannelMappingBuilder().build();
	}

	@Bean
	public SagaManager<CreateWorkspaceSagaData> createWorkspaceSagaManager(CreateWorkspaceSaga saga){
		return new SagaManagerImpl<>(saga);
	}

	@Bean
	public SagaManager<UpdateWorkspaceSagaData> updateWorkspaceSagaManager(UpdateWorkspaceSaga saga){
		return new SagaManagerImpl<>(saga);
	}

	@Bean
	public SagaManager<AddProjectToWorkspaceSagaData> addProjectToWorkspaceSagaManager(AddProjectToWorkspaceSaga saga){
		return new SagaManagerImpl<>(saga);
	}

}
		
