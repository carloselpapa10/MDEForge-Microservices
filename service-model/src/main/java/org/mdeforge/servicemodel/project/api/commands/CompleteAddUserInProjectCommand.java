package org.mdeforge.servicemodel.project.api.commands;

import java.util.List;
import io.eventuate.tram.commands.common.Command;
import org.mdeforge.servicemodel.project.api.info.*;

public class CompleteAddUserInProjectCommand implements Command{

	private ProjectInfo projectInfo;
	
	public CompleteAddUserInProjectCommand() {}

	public CompleteAddUserInProjectCommand(ProjectInfo projectInfo) {
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
