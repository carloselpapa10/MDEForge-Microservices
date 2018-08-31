package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.List;

public class RelationInfo {

    private String id;									
    private String name;									
	private ArtifactInfo fromartifactInfo;								
	private ArtifactInfo toartifactInfo;								

	public RelationInfo(){}
	
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
	public void setFromArtifactInfo(ArtifactInfo fromartifactInfo){
		this.fromartifactInfo = fromartifactInfo;
	}	

	public ArtifactInfo getFromArtifactInfo() {
		return fromartifactInfo;
	}
	public void setToArtifactInfo(ArtifactInfo toartifactInfo){
		this.toartifactInfo = toartifactInfo;
	}	

	public ArtifactInfo getToArtifactInfo() {
		return toartifactInfo;
	}
}			
