package org.mdeforge.servicemodel.workspace.api.events;

import org.mdeforge.servicemodel.workspace.api.info.*;

public class WorkspaceUpdatedEvent implements WorkspaceDomainEvent{
	
	private WorkspaceInfo workspaceInfo;

	public WorkspaceUpdatedEvent() {}

	public WorkspaceUpdatedEvent(WorkspaceInfo workspaceInfo) {
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
