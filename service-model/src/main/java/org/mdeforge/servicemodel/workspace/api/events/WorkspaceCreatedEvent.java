package org.mdeforge.servicemodel.workspace.api.events;

import org.mdeforge.servicemodel.workspace.api.info.*;

public class WorkspaceCreatedEvent implements WorkspaceDomainEvent{
	
	private WorkspaceInfo workspaceInfo;

	public WorkspaceCreatedEvent() {}

	public WorkspaceCreatedEvent(WorkspaceInfo workspaceInfo) {
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
