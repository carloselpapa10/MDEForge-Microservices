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
	private String state;

	public Workspace() {}

	public Workspace(String id, String name, String description, User owner, List<Project> projects, String state) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.projects = projects;
		this.state = state;
	}

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public void addProject(Project project){
	    this.projects.add(project);
    }

    public void removeProject(Project project){
	    this.projects.remove(project);
    }
}
