package org.mdeforge.servicemodel.user.api.info;

import java.util.ArrayList;
import java.util.List;

public class RoleInfo {

    private String id;									
    private String name;									

	public RoleInfo(){}
	
	public void setId(String id){
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setName(String name){
		this.name = name;
	}	

	public String getName() {
		return name;
	}
}			
