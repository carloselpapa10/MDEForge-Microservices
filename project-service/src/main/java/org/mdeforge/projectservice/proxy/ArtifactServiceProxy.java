package org.mdeforge.projectservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;
import org.mdeforge.servicemodel.artifact.api.commands.*;
import org.mdeforge.servicemodel.artifact.api.info.*;

@Component
public class ArtifactServiceProxy {

	public final CommandEndpoint<ValidateArtifactCommand> validateArtifactCommand = CommandEndpointBuilder
								.forCommand(ValidateArtifactCommand.class)
								.withChannel(Channels.ARTIFACTSERVICE)
								.withReply(Success.class)
								.build();			

}					
