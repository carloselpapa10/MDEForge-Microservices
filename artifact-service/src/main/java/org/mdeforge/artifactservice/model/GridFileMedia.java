package org.mdeforge.artifactservice.model;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="GridFileMedias")
public class GridFileMedia{

	@Id
	private String id; 
    private String idfile;									
    private String filename;									
    private String content;									
				
	public GridFileMedia() {}
				
	public void setId(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setIdFile(String idfile) {
		this.idfile = idfile;
	}	

	public String getIdFile() {
		return idfile;
	}
	public void setFileName(String filename) {
		this.filename = filename;
	}	

	public String getFileName() {
		return filename;
	}
	public void setContent(String content) {
		this.content = content;
	}	

	public String getContent() {
		return content;
	}

}
