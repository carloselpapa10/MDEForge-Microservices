package org.mdeforge.servicemodel.workspace.api.info;

import java.util.ArrayList;
import java.util.List;

public class WorkspaceInfo {

    private String id;									
    private String name;									
    private String description;									
    private String owner;									
	private List<String> projects;
	private String state;

	public WorkspaceInfo(){}

	public WorkspaceInfo(String id) {
		this.id = id;
	}

	public WorkspaceInfo(String name, String description, String owner, List<String> projects, String state) {
		this.name = name;
		this.description = description;
		this.owner = owner;
		this.projects = projects;
		this.state = state;
	}

    public WorkspaceInfo(String id, String name, String description, String owner, List<String> projects, String state) {
        this.id = id;
	    this.name = name;
        this.description = description;
        this.owner = owner;
        this.projects = projects;
        this.state = state;
    }

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

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}
}
