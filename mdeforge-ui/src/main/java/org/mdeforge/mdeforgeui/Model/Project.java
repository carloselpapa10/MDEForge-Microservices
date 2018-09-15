package org.mdeforge.mdeforgeui.Model;

import java.util.ArrayList;
import java.util.List;

public class Project {

    private String id;
    private String name;
    private String description;
    private boolean open;
    private String createddate;
    private String modifieddate;
    private String state;
    private List<Artifact> artifactlist = new ArrayList<>();
    private List<User> userlist = new ArrayList<>();
    private User owner;

    public Project() {
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

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
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
}
