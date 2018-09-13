package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

public class Role{

    private String id;									
    private String name;									

	public Role() {}

    public Role(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public String getName() {
		return name;
	}

}
