package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Projects")
public class Project{

    private String id;									
    private String name;									
    private String description;									
    private boolean open;									
    private String createddate;									
    private String modifieddate;									
	private List<Workspace> workspacelist = new ArrayList<>();								
	private List<Artifact> artifactlist = new ArrayList<>();								
	private List<User> userlist = new ArrayList<>();								
    private User owner;									

	public Project() {}

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
	public void setOpen(boolean open) {
		this.open = open;
	}	

	public boolean getOpen() {
		return open;
	}
	public void setCreatedDate(String createddate) {
		this.createddate = createddate;
	}	

	public String getCreatedDate() {
		return createddate;
	}
	public void setModifiedDate(String modifieddate) {
		this.modifieddate = modifieddate;
	}	

	public String getModifiedDate() {
		return modifieddate;
	}
	public void setWorkspaceList(List<Workspace> workspacelist) {
		this.workspacelist = workspacelist;
	}	

	public List<Workspace> getWorkspaceList() {
		return workspacelist;
	}
	public void setArtifactList(List<Artifact> artifactlist) {
		this.artifactlist = artifactlist;
	}	

	public List<Artifact> getArtifactList() {
		return artifactlist;
	}
	public void setUserList(List<User> userlist) {
		this.userlist = userlist;
	}	

	public List<User> getUserList() {
		return userlist;
	}
	public void setOwner(User owner) {
		this.owner = owner;
	}	

	public User getOwner() {
		return owner;
	}

}
