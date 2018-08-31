package org.mdeforge.servicemodel.workspace.api.commands;

import java.util.List;
import io.eventuate.tram.commands.common.Command;
import org.mdeforge.servicemodel.workspace.api.info.*;

public class CompleteCreateWorkspaceCommand implements Command{

	private WorkspaceInfo workspaceInfo;
	
	public CompleteCreateWorkspaceCommand() {}

	public CompleteCreateWorkspaceCommand(WorkspaceInfo workspaceInfo) {
		super();
		this.workspaceInfo = workspaceInfo;
	}

	public WorkspaceInfo getWorkspaceInfo() {
		return workspaceInfo;
	}
	
	public void setWorkspaceInfo(WorkspaceInfo workspaceInfo) {
		this.workspaceInfo = workspaceInfo;
	}

}
