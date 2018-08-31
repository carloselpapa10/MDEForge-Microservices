package org.mdeforge.servicemodel.workspace.api.info;

import java.util.ArrayList;
import java.util.List;

public class WorkspaceInfo {

    private String id;									
    private String name;									
    private String description;									
    private String owner;									
	private List<String> projects;							

	public WorkspaceInfo(){}
	
	public void setId(String id){
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setName(String name){
		this.name = name;
	}	

	public String getName() {
		return name;
	}
	public void setDescription(String description){
		this.description = description;
	}	

	public String getDescription() {
		return description;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}	

	public String getOwner() {
		return owner;
	}
	public void setProjects(List<String> projects){
		this.projects = projects;
	}	

	public List<String> getProjects() {
		return projects;
	}
}			
