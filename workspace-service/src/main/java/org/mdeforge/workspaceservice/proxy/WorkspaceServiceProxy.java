package org.mdeforge.workspaceservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;
import org.mdeforge.servicemodel.workspace.api.commands.*;
import org.mdeforge.servicemodel.workspace.api.info.*;

@Component
public class WorkspaceServiceProxy {

	public final CommandEndpoint<AddProjectToWorkspaceCommand> addProjectToWorkspaceCommand = CommandEndpointBuilder
								.forCommand(AddProjectToWorkspaceCommand.class)
								.withChannel(Channels.WORKSPACESERVICE)
								.withReply(Success.class)
								.build();			

	public final CommandEndpoint<RejectCreateWorkspaceCommand> rejectCreateWorkspaceCommand = CommandEndpointBuilder
								.forCommand(RejectCreateWorkspaceCommand.class)
								.withChannel(Channels.WORKSPACESERVICE)
								.withReply(Success.class)
								.build();			

	public final CommandEndpoint<CompleteCreateWorkspaceCommand> completeCreateWorkspaceCommand = CommandEndpointBuilder
								.forCommand(CompleteCreateWorkspaceCommand.class)
								.withChannel(Channels.WORKSPACESERVICE)
								.withReply(Success.class)
								.build();			

	public final CommandEndpoint<UpdateWorkspaceCommand> updateWorkspaceCommand = CommandEndpointBuilder
								.forCommand(UpdateWorkspaceCommand.class)
								.withChannel(Channels.WORKSPACESERVICE)
								.withReply(Success.class)
								.build();			

}					
