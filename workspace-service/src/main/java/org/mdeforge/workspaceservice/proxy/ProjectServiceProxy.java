package org.mdeforge.workspaceservice.proxy;

import org.springframework.stereotype.Component;
import io.eventuate.tram.sagas.simpledsl.CommandEndpoint;
import io.eventuate.tram.sagas.simpledsl.CommandEndpointBuilder;
import org.mdeforge.servicemodel.common.Channels;
import io.eventuate.tram.commands.common.Success;
import org.mdeforge.servicemodel.project.api.commands.*;
import org.mdeforge.servicemodel.project.api.info.*;

@Component
public class ProjectServiceProxy {

	public final CommandEndpoint<RejectAddProjectsToWorkspaceCommand> rejectAddProjectsToWorkspaceCommand = CommandEndpointBuilder
								.forCommand(RejectAddProjectsToWorkspaceCommand.class)
								.withChannel(Channels.PROJECTSERVICE)
								.withReply(Success.class)
								.build();			

	public final CommandEndpoint<RejectEditProjectsToWorkspaceCommand> rejectEditProjectsToWorkspaceCommand = CommandEndpointBuilder
								.forCommand(RejectEditProjectsToWorkspaceCommand.class)
								.withChannel(Channels.PROJECTSERVICE)
								.withReply(Success.class)
								.build();			

	public final CommandEndpoint<EditProjectsToWorkspaceCommand> editProjectsToWorkspaceCommand = CommandEndpointBuilder
								.forCommand(EditProjectsToWorkspaceCommand.class)
								.withChannel(Channels.PROJECTSERVICE)
								.withReply(ProjectInfo.class)
								.build();								

	public final CommandEndpoint<AddProjectsToWorkspaceCommand> addProjectsToWorkspaceCommand = CommandEndpointBuilder
								.forCommand(AddProjectsToWorkspaceCommand.class)
								.withChannel(Channels.PROJECTSERVICE)
								.withReply(ProjectInfo.class)
								.build();								

	public final CommandEndpoint<ValidateProjectCommand> validateProjectCommand = CommandEndpointBuilder
								.forCommand(ValidateProjectCommand.class)
								.withChannel(Channels.PROJECTSERVICE)
								.withReply(Success.class)
								.build();			

}					
