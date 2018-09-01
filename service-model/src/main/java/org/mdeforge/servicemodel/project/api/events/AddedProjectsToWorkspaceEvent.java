package org.mdeforge.servicemodel.project.api.events;

import org.mdeforge.servicemodel.project.api.info.*;

import java.util.List;

public class AddedProjectsToWorkspaceEvent implements ProjectDomainEvent{
	
	private ProjectInfo projectInfo;
	private List<ProjectInfo> projectInfoList;
	private String workspaceId;

	public AddedProjectsToWorkspaceEvent() {}

	public AddedProjectsToWorkspaceEvent(ProjectInfo projectInfo) {
		super();
		this.projectInfo = projectInfo;
	}

	public AddedProjectsToWorkspaceEvent(List<ProjectInfo> projectInfoList, String workspaceId) {
		this.projectInfoList = projectInfoList;
		this.workspaceId = workspaceId;
	}

	public ProjectInfo getProjectInfo() {
		return projectInfo;
	}

	public void setProjectInfo(ProjectInfo projectInfo) {
		this.projectInfo = projectInfo;
	}

	public List<ProjectInfo> getProjectInfoList() {
		return projectInfoList;
	}

	public void setProjectInfoList(List<ProjectInfo> projectInfoList) {
		this.projectInfoList = projectInfoList;
	}

	public String getWorkspaceId() {
		return workspaceId;
	}

	public void setWorkspaceId(String workspaceId) {
		this.workspaceId = workspaceId;
	}
}
