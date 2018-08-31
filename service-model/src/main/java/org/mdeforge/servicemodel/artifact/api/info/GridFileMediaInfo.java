package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.List;

public class GridFileMediaInfo {

    private String id;									
    private String idfile;									
    private String filename;									
    private String content;									

	public GridFileMediaInfo(){}
	
	public void setId(String id){
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setIdFile(String idfile){
		this.idfile = idfile;
	}	

	public String getIdFile() {
		return idfile;
	}
	public void setFileName(String filename){
		this.filename = filename;
	}	

	public String getFileName() {
		return filename;
	}
	public void setContent(String content){
		this.content = content;
	}	

	public String getContent() {
		return content;
	}
}			
