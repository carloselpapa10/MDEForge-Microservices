package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Comments")
public class Comment{

    private String id;									
    private String comment;									
    private int star;									
    private User user;									

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
	public void setUser(User user) {
		this.user = user;
	}	

	public User getUser() {
		return user;
	}

}
