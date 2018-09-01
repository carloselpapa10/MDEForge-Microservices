package org.mdeforge.servicemodel.project.api.commands;

import java.util.List;
import io.eventuate.tram.commands.common.Command;
import org.mdeforge.servicemodel.project.api.info.*;

public class RejectAddProjectsToWorkspaceCommand implements Command{

	private ProjectInfo projectInfo;
	private List<ProjectInfo> projectInfoList;
	
	public RejectAddProjectsToWorkspaceCommand() {}

	public RejectAddProjectsToWorkspaceCommand(ProjectInfo projectInfo) {
		super();
		this.projectInfo = projectInfo;
	}

	public RejectAddProjectsToWorkspaceCommand(List<ProjectInfo> projectInfoList) {
		this.projectInfoList = projectInfoList;
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
}
