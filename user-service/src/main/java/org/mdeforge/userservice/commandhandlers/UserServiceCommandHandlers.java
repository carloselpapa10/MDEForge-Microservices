package org.mdeforge.userservice.commandhandlers;

import org.mdeforge.servicemodel.common.Channels;
import org.mdeforge.servicemodel.user.api.commands.*;
import org.mdeforge.servicemodel.user.api.info.*;
import org.mdeforge.userservice.impl.*;
import org.mdeforge.userservice.model.*;
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

public class UserServiceCommandHandlers {

	private static final Logger log = LoggerFactory.getLogger(UserServiceCommandHandlers.class);

	@Autowired
	private UserServiceImpl userServiceImpl;

	public CommandHandlers commandHandlers() {
		return SagaCommandHandlersBuilder
				.fromChannel(Channels.USERSERVICE)
				.onMessage(ValidateUserCommand.class, this::handleValidateUserCommand)
				.onMessage(ValidateUserListCommand.class, this::handleValidateUserListCommand)
				.build();
	}		
		
	private Message handleValidateUserCommand(CommandMessage<ValidateUserCommand> cm) {
		log.info("handleValidateUserCommand() - UserServiceCommandHandlers - UserService");
		
		ValidateUserCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

	private Message handleValidateUserListCommand(CommandMessage<ValidateUserListCommand> cm) {
		log.info("handleValidateUserListCommand() - UserServiceCommandHandlers - UserService");
		
		ValidateUserListCommand command = cm.getCommand();
		/*TODO*/
		return withSuccess();
	}

}
