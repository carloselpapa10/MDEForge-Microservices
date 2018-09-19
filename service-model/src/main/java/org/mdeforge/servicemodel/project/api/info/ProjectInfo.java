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
	private List<String> workspacelist = new ArrayList<>();
	private List<String> artifactlist;
	private List<String> userlist;
    private String owner;
    private String state;

	public ProjectInfo(){}

	public ProjectInfo(String id) {
		this.id = id;
	}

    public ProjectInfo(String name, String description, boolean open, String owner, String state) {
        this.name = name;
        this.description = description;
        this.open = open;
        this.owner = owner;
        this.state = state;
    }

    public ProjectInfo(String id, String name, String description, boolean open, String owner, String state) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.open = open;
        this.owner = owner;
        this.state = state;
    }

	public ProjectInfo(String id, List<String> workspacelist) {
		this.id = id;
		this.workspacelist = workspacelist;
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

	public boolean isOpen() {
		return open;
	}

	public void setOpen(boolean open) {
		this.open = open;
	}

	public String getCreateddate() {
		return createddate;
	}

	public void setCreateddate(String createddate) {
		this.createddate = createddate;
	}

	public String getModifieddate() {
		return modifieddate;
	}

	public void setModifieddate(String modifieddate) {
		this.modifieddate = modifieddate;
	}

	public List<String> getWorkspacelist() {
		return workspacelist;
	}

	public void setWorkspacelist(List<String> workspacelist) {
		this.workspacelist = workspacelist;
	}

	public List<String> getArtifactlist() {
		return artifactlist;
	}

	public void setArtifactlist(List<String> artifactlist) {
		this.artifactlist = artifactlist;
	}

	public List<String> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<String> userlist) {
		this.userlist = userlist;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
