package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Projects")
public class Project{

    private String id;									
    private String name;									
    private String description;									
    private boolean open;									
    private String createddate;									
    private String modifieddate;
    private String state;
	//private List<Workspace> workspacelist = new ArrayList<>();

    @DBRef
    private List<Artifact> artifactlist = new ArrayList<>();

	@DBRef
	private List<User> userlist = new ArrayList<>();

	@DBRef
	private User owner;

	public Project() {}

    public Project(String id, String name, String description, boolean open, String state, User owner) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.open = open;
        this.state = state;
        this.owner = owner;
    }

    public Project(String id) {
		this.id = id;
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

	public List<Artifact> getArtifactlist() {
		return artifactlist;
	}

	public void setArtifactlist(List<Artifact> artifactlist) {
		this.artifactlist = artifactlist;
	}

	public List<User> getUserlist() {
		return userlist;
	}

	public void setUserlist(List<User> userlist) {
		this.userlist = userlist;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	/*public void addWorkspacelist(Workspace workspace){
	    this.workspacelist.add(workspace);
    }*/

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public void addUser(User user){
        this.userlist.add(user);
    }

    public void removeUser(User user){
        this.userlist.remove(user);
    }


}
