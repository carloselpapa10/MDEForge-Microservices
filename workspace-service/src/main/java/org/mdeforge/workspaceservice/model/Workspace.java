package org.mdeforge.workspaceservice.model;

import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Workspaces")
public class Workspace{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)						
	private String id; 
    private String name;									
    private String description;									
    private String owner;									
	private List<String> projects;
	private WorkspaceState state = WorkspaceState.CREATION_PENDING;
				
	public Workspace() {}

	public Workspace(String id) {
		this.id = id;
	}

	public Workspace(String name, String description, String owner, List<String> projects) {
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.projects = projects;

		if(projects == null || projects.size() == 0){
			this.state = WorkspaceState.CREATED;
		}
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public List<String> getProjects() {
		return projects;
	}

	public void setProjects(List<String> projects) {
		this.projects = projects;
	}

	public WorkspaceState getState() {
		return state;
	}

	public void setState(WorkspaceState state) {
		this.state = state;
	}
}
