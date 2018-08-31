package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Users")
public class User{

    private String id;									
    private String firstname;									
    private String lastname;									
    private String email;									
    private String username;									
    private String image;									
    private String password;									
    private boolean enabled;									
	private List<Role> roles = new ArrayList<>();							
	private List<Artifact> ownerartifactlist = new ArrayList<>();								
	private List<Artifact> sharedartifactlist = new ArrayList<>();								
    private Workspace workspacelist;									

	public User() {}

	public void setId(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}	

	public String getFirstname() {
		return firstname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}	

	public String getLastname() {
		return lastname;
	}
	public void setEmail(String email) {
		this.email = email;
	}	

	public String getEmail() {
		return email;
	}
	public void setUsername(String username) {
		this.username = username;
	}	

	public String getUsername() {
		return username;
	}
	public void setImage(String image) {
		this.image = image;
	}	

	public String getImage() {
		return image;
	}
	public void setPassword(String password) {
		this.password = password;
	}	

	public String getPassword() {
		return password;
	}
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}	

	public boolean getEnabled() {
		return enabled;
	}
	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}	

	public List<Role> getRoles() {
		return roles;
	}
	public void setOwnerArtifactList(List<Artifact> ownerartifactlist) {
		this.ownerartifactlist = ownerartifactlist;
	}	

	public List<Artifact> getOwnerArtifactList() {
		return ownerartifactlist;
	}
	public void setSharedArtifactList(List<Artifact> sharedartifactlist) {
		this.sharedartifactlist = sharedartifactlist;
	}	

	public List<Artifact> getSharedArtifactList() {
		return sharedartifactlist;
	}
	public void setWorkspaceList(Workspace workspacelist) {
		this.workspacelist = workspacelist;
	}	

	public Workspace getWorkspaceList() {
		return workspacelist;
	}

}
