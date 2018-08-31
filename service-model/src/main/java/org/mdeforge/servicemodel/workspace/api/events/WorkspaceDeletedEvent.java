package org.mdeforge.servicemodel.workspace.api.events;

import org.mdeforge.servicemodel.workspace.api.info.*;

public class WorkspaceDeletedEvent implements WorkspaceDomainEvent{
	
	private WorkspaceInfo workspaceInfo;

	public WorkspaceDeletedEvent() {}

	public WorkspaceDeletedEvent(WorkspaceInfo workspaceInfo) {
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
