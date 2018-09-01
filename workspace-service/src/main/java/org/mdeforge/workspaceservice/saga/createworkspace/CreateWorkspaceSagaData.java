package org.mdeforge.workspaceservice.saga.createworkspace;

import java.util.ArrayList;
import java.util.List;

public class CreateWorkspaceSagaData {

	private String workspaceId;
	private String owner;
	private List<String> projects;
	private List<String> oldProjects;

	public CreateWorkspaceSagaData() {}

	public CreateWorkspaceSagaData(String workspaceId, String owner, List<String> projects) {
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

	public List<String> getOldProjects() {
		return oldProjects;
	}

	public void setOldProjects(List<String> oldProjects) {
		this.oldProjects = oldProjects;
	}
}
