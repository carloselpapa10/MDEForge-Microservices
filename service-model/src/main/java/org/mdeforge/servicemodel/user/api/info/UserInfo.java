package org.mdeforge.servicemodel.user.api.info;

import java.util.ArrayList;
import java.util.List;

public class UserInfo {

    private String id;									
    private String firstname;									
    private String lastname;									
    private String email;									
    private String username;									
    private String image;									
    private String password;									
    private boolean enabled;									
	private List<RoleInfo> rolesInfo = new ArrayList<>();							
	private List<String> ownerartifactlist;							
	private List<String> sharedartifactlist;							
    private String workspacelist;									

	public UserInfo(){}
	
	public void setId(String id){
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}	

	public String getFirstname() {
		return firstname;
	}
	public void setLastname(String lastname){
		this.lastname = lastname;
	}	

	public String getLastname() {
		return lastname;
	}
	public void setEmail(String email){
		this.email = email;
	}	

	public String getEmail() {
		return email;
	}
	public void setUsername(String username){
		this.username = username;
	}	

	public String getUsername() {
		return username;
	}
	public void setImage(String image){
		this.image = image;
	}	

	public String getImage() {
		return image;
	}
	public void setPassword(String password){
		this.password = password;
	}	

	public String getPassword() {
		return password;
	}
	public void setEnabled(boolean enabled){
		this.enabled = enabled;
	}	

	public boolean getEnabled() {
		return enabled;
	}
	public void setRolesInfo(List<RoleInfo> rolesInfo){
		this.rolesInfo = rolesInfo;
	}	

	public List<RoleInfo> getRolesInfo() {
		return rolesInfo;
	}
	public void setOwnerArtifactList(List<String> ownerartifactlist){
		this.ownerartifactlist = ownerartifactlist;
	}	

	public List<String> getOwnerArtifactList() {
		return ownerartifactlist;
	}
	public void setSharedArtifactList(List<String> sharedartifactlist){
		this.sharedartifactlist = sharedartifactlist;
	}	

	public List<String> getSharedArtifactList() {
		return sharedartifactlist;
	}
	public void setWorkspaceList(String workspacelist){
		this.workspacelist = workspacelist;
	}	

	public String getWorkspaceList() {
		return workspacelist;
	}
}			
