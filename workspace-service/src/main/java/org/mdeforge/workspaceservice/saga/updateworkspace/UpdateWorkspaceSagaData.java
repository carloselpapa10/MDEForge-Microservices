package org.mdeforge.workspaceservice.saga.updateworkspace;

import java.util.ArrayList;
import java.util.List;

public class UpdateWorkspaceSagaData {

    private String workspaceId;
    private String owner;
    private List<String> projects;

	public UpdateWorkspaceSagaData() {}

    public UpdateWorkspaceSagaData(String workspaceId, String owner, List<String> projects) {
        this.workspaceId = workspaceId;
        this.owner = owner;
        this.projects = projects;
    }

    public String getWorkspaceId() {
        return workspaceId;
    }

    public void setWorkspaceId(String workspaceId) {
        this.workspaceId = workspaceId;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
