package org.mdeforge.servicemodel.project.api.events;

import org.mdeforge.servicemodel.project.api.info.*;

public class RemovedUserFromProjectEvent implements ProjectDomainEvent{
	
	private ProjectInfo projectInfo;
	private String userId;

	public RemovedUserFromProjectEvent() {}

	public RemovedUserFromProjectEvent(ProjectInfo projectInfo) {
		super();
		this.projectInfo = projectInfo;
	}

	public RemovedUserFromProjectEvent(ProjectInfo projectInfo, String userId) {
		this.projectInfo = projectInfo;
		this.userId = userId;
	}

	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
