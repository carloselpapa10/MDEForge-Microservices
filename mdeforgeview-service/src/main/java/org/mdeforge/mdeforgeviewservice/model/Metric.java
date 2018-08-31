package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Metrics")
public class Metric{

    private String id;									
    private String name;									
    private String code;									
    private Artifact artifact;									

	public Metric() {}

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
	public void setCode(String code) {
		this.code = code;
	}	

	public String getCode() {
		return code;
	}
	public void setArtifact(Artifact artifact) {
		this.artifact = artifact;
	}	

	public Artifact getArtifact() {
		return artifact;
	}

}
