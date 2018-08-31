package org.mdeforge.projectservice.webapi;

import java.util.ArrayList;
import java.util.List;

public class CreateProjectRequest {

	private String name;
	private String description;
	private String owner;

	public CreateProjectRequest() {}

	public CreateProjectRequest(String name, String description, String owner) {
		this.name = name;
		this.description = description;
		this.owner = owner;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
}
