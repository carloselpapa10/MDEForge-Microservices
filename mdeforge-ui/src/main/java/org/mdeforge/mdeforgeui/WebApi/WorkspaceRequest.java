package org.mdeforge.mdeforgeui.WebApi;

import java.util.List;

public class WorkspaceRequest {

    private String name;
    private String description;
    private String owner;
    private List<String> projects;

    public WorkspaceRequest() {
    }

    public WorkspaceRequest(String name, String description, String owner, List<String> projects) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.projects = projects;
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

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public List<String> getProjects() {
        return projects;
    }

    public void setProjects(List<String> projects) {
        this.projects = projects;
    }
}
