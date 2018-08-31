package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.List;

public class MetricInfo {

    private String id;									
    private String name;									
    private String code;									
    private String artifact;									

	public MetricInfo(){}
	
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
	public void setCode(String code){
		this.code = code;
	}	

	public String getCode() {
		return code;
	}
	public void setArtifact(String artifact){
		this.artifact = artifact;
	}	

	public String getArtifact() {
		return artifact;
	}
}			
