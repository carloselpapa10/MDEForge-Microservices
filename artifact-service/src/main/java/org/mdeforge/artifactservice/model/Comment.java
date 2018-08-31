package org.mdeforge.artifactservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Comments")
public class Comment{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)						
	private String id; 
    private String comment;									
    private int star;									
    private String user;									
				
	public Comment() {}
				
	public void setId(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}	

	public String getComment() {
		return comment;
	}
	public void setStar(int star) {
		this.star = star;
	}	

	public int getStar() {
		return star;
	}
	public void setUser(String user) {
		this.user = user;
	}	

	public String getUser() {
		return user;
	}

}
