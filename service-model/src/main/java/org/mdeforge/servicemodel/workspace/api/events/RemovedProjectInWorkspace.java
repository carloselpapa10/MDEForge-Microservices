package org.mdeforge.servicemodel.workspace.api.events;

import org.mdeforge.servicemodel.workspace.api.info.*;

public class RemovedProjectInWorkspace implements WorkspaceDomainEvent{
	
	private WorkspaceInfo workspaceInfo;

	public RemovedProjectInWorkspace() {}

	public RemovedProjectInWorkspace(WorkspaceInfo workspaceInfo) {
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
