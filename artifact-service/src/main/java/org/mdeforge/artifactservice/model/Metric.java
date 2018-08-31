package org.mdeforge.artifactservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Metrics")
public class Metric{

	@Id
	private String id; 
    private String name;									
    private String code;									
    private String artifact;									
				
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
	public void setArtifact(String artifact) {
		this.artifact = artifact;
	}	

	public String getArtifact() {
		return artifact;
	}

}
