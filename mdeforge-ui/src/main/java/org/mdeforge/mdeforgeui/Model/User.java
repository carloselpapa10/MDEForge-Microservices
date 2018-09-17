package org.mdeforge.mdeforgeui.Model;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String id;

    @NotEmpty(message = "This field is required")
    private String email;

    @NotEmpty(message = "This field is required")
    private String password;

    @NotEmpty(message = "This field is required")
    private String firstname;

    @NotEmpty(message = "This field is required")
    private String lastname;

    @NotEmpty(message = "This field is required")
    private String username;

    private String image;
    private boolean enabled;
    private List<Role> roles = new ArrayList<>();


    public User() {}

    public User(String id) {
        this.id = id;
    }


    public User(User user) {
        this(user.getId(), user.getEmail(), user.getPassword(), user.getFirstname(), user.getLastname(), user.getUsername(), user.getImage(), user.isEnabled(), user.getRoles());
    }

    public User(String id, String email, String password, String firstname, String lastname, String username, String image, boolean enabled, List<Role> roles) {
        this.id = id;
        this.email = email;
        this.password = password;
        this.firstname = firstname;
        this.lastname = lastname;
        this.username = username;
        this.image = image;
        this.enabled = enabled;
        this.roles = roles;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }
}
