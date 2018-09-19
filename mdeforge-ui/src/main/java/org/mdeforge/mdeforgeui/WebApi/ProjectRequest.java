package org.mdeforge.mdeforgeui.WebApi;

public class ProjectRequest {

    private String name;
    private String description;
    private boolean open;
    private String owner;

    public ProjectRequest() {
    }

    public ProjectRequest(String name, String description, boolean open, String owner) {
        this.name = name;
        this.description = description;
        this.open = open;
        this.owner = owner;
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

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }
}
