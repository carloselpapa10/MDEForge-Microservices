package org.mdeforge.servicemodel.project.api.commands;

import java.util.List;
import io.eventuate.tram.commands.common.Command;
import org.mdeforge.servicemodel.project.api.info.*;

public class RejectEditProjectsToWorkspaceCommand implements Command{

	private ProjectInfo projectInfo;
	
	public RejectEditProjectsToWorkspaceCommand() {}

	public RejectEditProjectsToWorkspaceCommand(ProjectInfo projectInfo) {
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
