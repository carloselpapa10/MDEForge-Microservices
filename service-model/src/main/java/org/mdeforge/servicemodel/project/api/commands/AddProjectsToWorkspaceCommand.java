package org.mdeforge.servicemodel.project.api.commands;

import java.util.List;
import io.eventuate.tram.commands.common.Command;
import org.mdeforge.servicemodel.project.api.info.*;

public class AddProjectsToWorkspaceCommand implements Command{

	private ProjectInfo projectInfo;
	private List<ProjectInfo> projectInfoList;
	private String workspaceId;

	public AddProjectsToWorkspaceCommand() {}

	public AddProjectsToWorkspaceCommand(ProjectInfo projectInfo) {
		super();
		this.projectInfo = projectInfo;
	}

	public AddProjectsToWorkspaceCommand(List<ProjectInfo> projectInfoList, String workspaceId) {
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
