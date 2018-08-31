package org.mdeforge.projectservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;
import org.mdeforge.servicemodel.user.api.commands.*;
import org.mdeforge.servicemodel.user.api.info.*;

@Component
public class UserServiceProxy {

	public final CommandEndpoint<ValidateUserCommand> validateUserCommand = CommandEndpointBuilder
								.forCommand(ValidateUserCommand.class)
								.withChannel(Channels.USERSERVICE)
								.withReply(Success.class)
								.build();			

	public final CommandEndpoint<ValidateUserListCommand> validateUserListCommand = CommandEndpointBuilder
								.forCommand(ValidateUserListCommand.class)
								.withChannel(Channels.USERSERVICE)
								.withReply(Success.class)
								.build();			

}					
