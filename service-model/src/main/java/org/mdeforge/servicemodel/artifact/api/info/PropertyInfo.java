package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.List;

public class PropertyInfo {

    private String id;									
    private String name;									
    private String value;									

	public PropertyInfo(){}
	
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
	public void setValue(String value){
		this.value = value;
	}	

	public String getValue() {
		return value;
	}
}			
