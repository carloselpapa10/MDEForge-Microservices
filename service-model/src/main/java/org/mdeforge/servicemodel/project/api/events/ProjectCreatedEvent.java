package org.mdeforge.servicemodel.project.api.events;

import org.mdeforge.servicemodel.project.api.info.*;

public class ProjectCreatedEvent implements ProjectDomainEvent{
	
	private ProjectInfo projectInfo;

	public ProjectCreatedEvent() {}

	public ProjectCreatedEvent(ProjectInfo projectInfo) {
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
