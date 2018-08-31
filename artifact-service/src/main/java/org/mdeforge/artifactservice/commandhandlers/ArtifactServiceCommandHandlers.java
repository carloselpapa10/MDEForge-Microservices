package org.mdeforge.artifactservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.artifact.api.commands.*;
import org.mdeforge.servicemodel.artifact.api.info.*;
import org.mdeforge.artifactservice.impl.*;
import org.mdeforge.artifactservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import io.eventuate.tram.commands.consumer.CommandHandlers;
import io.eventuate.tram.commands.consumer.CommandMessage;
import io.eventuate.tram.messaging.common.Message;
import io.eventuate.tram.sagas.participant.SagaCommandHandlersBuilder;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withFailure;
import static io.eventuate.tram.commands.consumer.CommandHandlerReplyBuilder.withSuccess;
import java.util.ArrayList;
import java.util.List;

public class ArtifactServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(ArtifactServiceCommandHandlers.class);

	@Autowired
	private ArtifactServiceImpl artifactServiceImpl;

	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.ARTIFACTSERVICE)
				.onMessage(ValidateArtifactCommand.class, this::handleValidateArtifactCommand)
				.build();
	}		
		
	private Message handleValidateArtifactCommand(CommandMessage<ValidateArtifactCommand> cm) {
		log.info("handleValidateArtifactCommand() - ArtifactServiceCommandHandlers - ArtifactService");
		
		ValidateArtifactCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

}
