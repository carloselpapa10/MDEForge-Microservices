package org.mdeforge.projectservice.webapi;

public class CreateProjectResponse {

	private String idProject;

	public CreateProjectResponse() {}

	public CreateProjectResponse(String idProject) {
		this.idProject = idProject;
	}

	public String getIdProject() {
		return idProject;
	}

	public void setIdProject(String idProject) {
		this.idProject = idProject;
	}
}
