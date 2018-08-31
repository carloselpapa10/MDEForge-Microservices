package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.List;

public class ArtifactInfo {

    private String id;									
    private String name;									
    private String description;									
    private boolean open;									
    private boolean generated;									
    private String created;									
    private String modified;									
    private String authors;									
    private String version;									
    private String nameforindex;									
    private String descriptionforindex;									
    private String weightedcontentsthree;									
    private String weightedcontentstwo;									
    private String weightedcontentsone;									
    private String defaultweightedcontents;									
	private List<String> tags;							
    private String author;									
	private List<String> projectlist;							
	private List<String> shareduserlist;							
	private GridFileMediaInfo fileInfo;								
	private List<CommentInfo> commentsInfo = new ArrayList<>();							
	private List<MetricInfo> metricsInfo = new ArrayList<>();							
	private List<RelationInfo> relationsInfo = new ArrayList<>();							
	private List<PropertyInfo> propertiesInfo = new ArrayList<>();							

	public ArtifactInfo(){}
	
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
	public void setDescription(String description){
		this.description = description;
	}	

	public String getDescription() {
		return description;
	}
	public void setOpen(boolean open){
		this.open = open;
	}	

	public boolean getOpen() {
		return open;
	}
	public void setGenerated(boolean generated){
		this.generated = generated;
	}	

	public boolean getGenerated() {
		return generated;
	}
	public void setCreated(String created){
		this.created = created;
	}	

	public String getCreated() {
		return created;
	}
	public void setModified(String modified){
		this.modified = modified;
	}	

	public String getModified() {
		return modified;
	}
	public void setAuthors(String authors){
		this.authors = authors;
	}	

	public String getAuthors() {
		return authors;
	}
	public void setVersion(String version){
		this.version = version;
	}	

	public String getVersion() {
		return version;
	}
	public void setNameForIndex(String nameforindex){
		this.nameforindex = nameforindex;
	}	

	public String getNameForIndex() {
		return nameforindex;
	}
	public void setDescriptionForIndex(String descriptionforindex){
		this.descriptionforindex = descriptionforindex;
	}	

	public String getDescriptionForIndex() {
		return descriptionforindex;
	}
	public void setWeightedContentsThree(String weightedcontentsthree){
		this.weightedcontentsthree = weightedcontentsthree;
	}	

	public String getWeightedContentsThree() {
		return weightedcontentsthree;
	}
	public void setWeightedContentsTwo(String weightedcontentstwo){
		this.weightedcontentstwo = weightedcontentstwo;
	}	

	public String getWeightedContentsTwo() {
		return weightedcontentstwo;
	}
	public void setWeightedContentsOne(String weightedcontentsone){
		this.weightedcontentsone = weightedcontentsone;
	}	

	public String getWeightedContentsOne() {
		return weightedcontentsone;
	}
	public void setDefaultWeightedContents(String defaultweightedcontents){
		this.defaultweightedcontents = defaultweightedcontents;
	}	

	public String getDefaultWeightedContents() {
		return defaultweightedcontents;
	}
	public void setTags(List<String> tags){
		this.tags = tags;
	}	

	public List<String> getTags() {
		return tags;
	}
	public void setAuthor(String author){
		this.author = author;
	}	

	public String getAuthor() {
		return author;
	}
	public void setProjectList(List<String> projectlist){
		this.projectlist = projectlist;
	}	

	public List<String> getProjectList() {
		return projectlist;
	}
	public void setSharedUserList(List<String> shareduserlist){
		this.shareduserlist = shareduserlist;
	}	

	public List<String> getSharedUserList() {
		return shareduserlist;
	}
	public void setFileInfo(GridFileMediaInfo fileInfo){
		this.fileInfo = fileInfo;
	}	

	public GridFileMediaInfo getFileInfo() {
		return fileInfo;
	}
	public void setCommentsInfo(List<CommentInfo> commentsInfo){
		this.commentsInfo = commentsInfo;
	}	

	public List<CommentInfo> getCommentsInfo() {
		return commentsInfo;
	}
	public void setMetricsInfo(List<MetricInfo> metricsInfo){
		this.metricsInfo = metricsInfo;
	}	

	public List<MetricInfo> getMetricsInfo() {
		return metricsInfo;
	}
	public void setRelationsInfo(List<RelationInfo> relationsInfo){
		this.relationsInfo = relationsInfo;
	}	

	public List<RelationInfo> getRelationsInfo() {
		return relationsInfo;
	}
	public void setPropertiesInfo(List<PropertyInfo> propertiesInfo){
		this.propertiesInfo = propertiesInfo;
	}	

	public List<PropertyInfo> getPropertiesInfo() {
		return propertiesInfo;
	}
}			
