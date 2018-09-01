package org.mdeforge.workspaceservice.webapi;

public class CreateWorkspaceResponse {

	private String workspaceId;

	public CreateWorkspaceResponse() {}

	public CreateWorkspaceResponse(String workspaceId) {
		this.workspaceId = workspaceId;
	}

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}
}
