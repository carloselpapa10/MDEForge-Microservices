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
    private String state;

	public UserInfo(){}

	public UserInfo(String id) {
		this.id = id;
	}

	public UserInfo(String firstname, String lastname, String email, String username, String state, String password, List<RoleInfo> rolesInfo, String image) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.username = username;
		this.state = state;
		this.password = password;
		this.rolesInfo = rolesInfo;
	}

    public UserInfo(String id, String firstname, String lastname, String email, String username, String state, String password, List<RoleInfo> rolesInfo, String image) {
	    this.id = id;
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.state = state;
        this.password = password;
    }

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<RoleInfo> getRolesInfo() {
		return rolesInfo;
	}

	public void setRolesInfo(List<RoleInfo> rolesInfo) {
		this.rolesInfo = rolesInfo;
	}

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
