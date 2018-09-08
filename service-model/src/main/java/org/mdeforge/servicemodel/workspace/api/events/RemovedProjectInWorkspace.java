package org.mdeforge.servicemodel.workspace.api.events;

import org.mdeforge.servicemodel.workspace.api.info.*;

public class RemovedProjectInWorkspace implements WorkspaceDomainEvent{
	
	private WorkspaceInfo workspaceInfo;
    private String projectId;

	public RemovedProjectInWorkspace() {}

	public RemovedProjectInWorkspace(WorkspaceInfo workspaceInfo) {
		super();
		this.workspaceInfo = workspaceInfo;
	}

    public RemovedProjectInWorkspace(WorkspaceInfo workspaceInfo, String projectId) {
        this.workspaceInfo = workspaceInfo;
        this.projectId = projectId;
    }

    public WorkspaceInfo getWorkspaceInfo() {
		return workspaceInfo;
	}

	public void setWorkspaceInfo(WorkspaceInfo workspaceInfo) {
		this.workspaceInfo = workspaceInfo;
	}

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }
}
