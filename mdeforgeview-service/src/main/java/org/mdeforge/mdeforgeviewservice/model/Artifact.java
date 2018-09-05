package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Artifacts")
public class Artifact{

    private String id;									

	public Artifact() {}

	public void setId(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}

}
