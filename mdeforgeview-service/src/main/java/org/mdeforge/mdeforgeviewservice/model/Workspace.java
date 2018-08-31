package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Workspaces")
public class Workspace{

    private String id;									
    private String name;									
    private String description;									
    private User owner;									
	private List<Project> projects = new ArrayList<>();								

	public Workspace() {}

	public void setId(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

	public String getDescription() {
		return description;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}	

	public User getOwner() {
		return owner;
	}
	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}	

	public List<Project> getProjects() {
		return projects;
	}

}
