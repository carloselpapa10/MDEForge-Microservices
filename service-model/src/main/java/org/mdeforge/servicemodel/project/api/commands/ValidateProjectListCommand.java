package org.mdeforge.servicemodel.project.api.commands;

import io.eventuate.tram.commands.common.Command;
import org.mdeforge.servicemodel.project.api.info.ProjectInfo;

import java.util.List;

public class ValidateProjectListCommand implements Command {

    private List<ProjectInfo> projectInfoList;

    public ValidateProjectListCommand() {
    }

    public ValidateProjectListCommand(List<ProjectInfo> projectInfoList) {
        this.projectInfoList = projectInfoList;
    }

    public List<ProjectInfo> getProjectInfoList() {
        return projectInfoList;
    }

    public void setProjectInfoList(List<ProjectInfo> projectInfoList) {
        this.projectInfoList = projectInfoList;
    }
}
