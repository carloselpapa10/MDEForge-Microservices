package org.mdeforge.projectservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;
import org.mdeforge.servicemodel.project.api.commands.*;
import org.mdeforge.servicemodel.project.api.info.*;

@Component
public class ProjectServiceProxy {

	public final CommandEndpoint<AddArtifactToProjectCommand> addArtifactToProjectCommand = CommandEndpointBuilder
								.forCommand(AddArtifactToProjectCommand.class)
								.withChannel(Channels.PROJECTSERVICE)
								.withReply(Success.class)
								.build();			

	public final CommandEndpoint<CompleteAddUserInProjectCommand> completeAddUserInProjectCommand = CommandEndpointBuilder
								.forCommand(CompleteAddUserInProjectCommand.class)
								.withChannel(Channels.PROJECTSERVICE)
								.withReply(Success.class)
								.build();			

}					
