package org.mdeforge.servicemodel.workspace.api.events;

import org.mdeforge.servicemodel.workspace.api.info.*;

public class WorkspaceCreationRejectedEvent implements WorkspaceDomainEvent {

    private WorkspaceInfo workspaceInfo;

    public WorkspaceCreationRejectedEvent() {
    }

    public WorkspaceCreationRejectedEvent(WorkspaceInfo workspaceInfo) {
        this.workspaceInfo = workspaceInfo;
    }

    public WorkspaceInfo getWorkspaceInfo() {
        return workspaceInfo;
    }

    public void setWorkspaceInfo(WorkspaceInfo workspaceInfo) {
        this.workspaceInfo = workspaceInfo;
    }
}
