package org.mdeforge.servicemodel.project.api.info;

import java.util.ArrayList;
import java.util.List;

public class ProjectInfo {

    private String id;									
    private String name;									
    private String description;									
    private boolean open;									
    private String createddate;									
    private String modifieddate;									
	private List<String> workspacelist;							
	private List<String> artifactlist;							
	private List<String> userlist;							
    private String owner;									

	public ProjectInfo(){}
	
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
	public void setOpen(boolean open){
		this.open = open;
	}	

	public boolean getOpen() {
		return open;
	}
	public void setCreatedDate(String createddate){
		this.createddate = createddate;
	}	

	public String getCreatedDate() {
		return createddate;
	}
	public void setModifiedDate(String modifieddate){
		this.modifieddate = modifieddate;
	}	

	public String getModifiedDate() {
		return modifieddate;
	}
	public void setWorkspaceList(List<String> workspacelist){
		this.workspacelist = workspacelist;
	}	

	public List<String> getWorkspaceList() {
		return workspacelist;
	}
	public void setArtifactList(List<String> artifactlist){
		this.artifactlist = artifactlist;
	}	

	public List<String> getArtifactList() {
		return artifactlist;
	}
	public void setUserList(List<String> userlist){
		this.userlist = userlist;
	}	

	public List<String> getUserList() {
		return userlist;
	}
	public void setOwner(String owner){
		this.owner = owner;
	}	

	public String getOwner() {
		return owner;
	}
}			
