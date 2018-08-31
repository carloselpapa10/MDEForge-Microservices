package org.mdeforge.artifactservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Relations")
public class Relation{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)						
	private String id; 
    private String name;									
	private Artifact fromartifact;								
	private Artifact toartifact;								
				
	public Relation() {}
				
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
	public void setFromArtifact(Artifact fromartifact) {
		this.fromartifact = fromartifact;
	}	

	public Artifact getFromArtifact() {
		return fromartifact;
	}
	public void setToArtifact(Artifact toartifact) {
		this.toartifact = toartifact;
	}	

	public Artifact getToArtifact() {
		return toartifact;
	}

}
