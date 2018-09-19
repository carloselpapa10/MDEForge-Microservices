package org.mdeforge.projectservice.webapi;

import java.util.ArrayList;
import java.util.List;

public class CreateProjectRequest {

	private String name;
	private String description;
	private String owner;
    private boolean open;

    public CreateProjectRequest() {}

    public CreateProjectRequest(String name, String description, String owner, boolean open) {
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.open = open;
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
