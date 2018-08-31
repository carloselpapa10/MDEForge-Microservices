package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.List;

public class CommentInfo {

    private String id;									
    private String comment;									
    private int star;									
    private String user;									

	public CommentInfo(){}
	
	public void setId(String id){
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setComment(String comment){
		this.comment = comment;
	}	

	public String getComment() {
		return comment;
	}
	public void setStar(int star){
		this.star = star;
	}	

	public int getStar() {
		return star;
	}
	public void setUser(String user){
		this.user = user;
	}	

	public String getUser() {
		return user;
	}
}			
