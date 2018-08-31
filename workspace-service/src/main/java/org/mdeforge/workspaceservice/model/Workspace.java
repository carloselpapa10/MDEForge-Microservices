package org.mdeforge.workspaceservice.model;

import java.util.ArrayList;
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
	public void setOwner(String owner) {
		this.owner = owner;
	}	

	public String getOwner() {
		return owner;
	}
	public void setProjects(List<String> projects) {
		this.projects = projects;
	}	

	public List<String> getProjects() {
		return projects;
	}

}
