package org.mdeforge.servicemodel.project.api.events;

import org.mdeforge.servicemodel.project.api.info.*;

public class RemovedUserFromProjectEvent implements ProjectDomainEvent{
	
	private ProjectInfo projectInfo;

	public RemovedUserFromProjectEvent() {}

	public RemovedUserFromProjectEvent(ProjectInfo projectInfo) {
		super();
		this.projectInfo = projectInfo;
	}

	
	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

}
