package org.mdeforge.artifactservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Propertys")
public class Property{

	@Id
	private String id; 
    private String name;									
    private String value;									
				
	public Property() {}
				
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
	public void setValue(String value) {
		this.value = value;
	}	

	public String getValue() {
		return value;
	}

}
