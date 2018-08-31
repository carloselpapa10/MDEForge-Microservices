package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.List;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Artifacts")
public class Artifact{

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
	private List<String> tags = new ArrayList<>();								
    private User author;									
	private List<Project> projectlist = new ArrayList<>();								
	private List<User> shareduserlist = new ArrayList<>();								
	private GridFileMedia file;								
	private List<Comment> comments = new ArrayList<>();							
	private List<Metric> metrics = new ArrayList<>();							
	private List<Relation> relations = new ArrayList<>();							
	private List<Property> properties = new ArrayList<>();							

	public Artifact() {}

	public void setId(String id) {
		this.id = id;
	}	

	public String getId() {
		return id;
	}
	public void setName(String name) {
		this.name = name;
	}	

	public String getName() {
		return name;
	}
	public void setDescription(String description) {
		this.description = description;
	}	

	public String getDescription() {
		return description;
	}
	public void setOpen(boolean open) {
		this.open = open;
	}	

	public boolean getOpen() {
		return open;
	}
	public void setGenerated(boolean generated) {
		this.generated = generated;
	}	

	public boolean getGenerated() {
		return generated;
	}
	public void setCreated(String created) {
		this.created = created;
	}	

	public String getCreated() {
		return created;
	}
	public void setModified(String modified) {
		this.modified = modified;
	}	

	public String getModified() {
		return modified;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}	

	public String getAuthors() {
		return authors;
	}
	public void setVersion(String version) {
		this.version = version;
	}	

	public String getVersion() {
		return version;
	}
	public void setNameForIndex(String nameforindex) {
		this.nameforindex = nameforindex;
	}	

	public String getNameForIndex() {
		return nameforindex;
	}
	public void setDescriptionForIndex(String descriptionforindex) {
		this.descriptionforindex = descriptionforindex;
	}	

	public String getDescriptionForIndex() {
		return descriptionforindex;
	}
	public void setWeightedContentsThree(String weightedcontentsthree) {
		this.weightedcontentsthree = weightedcontentsthree;
	}	

	public String getWeightedContentsThree() {
		return weightedcontentsthree;
	}
	public void setWeightedContentsTwo(String weightedcontentstwo) {
		this.weightedcontentstwo = weightedcontentstwo;
	}	

	public String getWeightedContentsTwo() {
		return weightedcontentstwo;
	}
	public void setWeightedContentsOne(String weightedcontentsone) {
		this.weightedcontentsone = weightedcontentsone;
	}	

	public String getWeightedContentsOne() {
		return weightedcontentsone;
	}
	public void setDefaultWeightedContents(String defaultweightedcontents) {
		this.defaultweightedcontents = defaultweightedcontents;
	}	

	public String getDefaultWeightedContents() {
		return defaultweightedcontents;
	}
	public void setTags(List<String> tags) {
		this.tags = tags;
	}	

	public List<String> getTags() {
		return tags;
	}
	public void setAuthor(User author) {
		this.author = author;
	}	

	public User getAuthor() {
		return author;
	}
	public void setProjectList(List<Project> projectlist) {
		this.projectlist = projectlist;
	}	

	public List<Project> getProjectList() {
		return projectlist;
	}
	public void setSharedUserList(List<User> shareduserlist) {
		this.shareduserlist = shareduserlist;
	}	

	public List<User> getSharedUserList() {
		return shareduserlist;
	}
	public void setFile(GridFileMedia file) {
		this.file = file;
	}	

	public GridFileMedia getFile() {
		return file;
	}
	public void setComments(List<Comment> comments) {
		this.comments = comments;
	}	

	public List<Comment> getComments() {
		return comments;
	}
	public void setMetrics(List<Metric> metrics) {
		this.metrics = metrics;
	}	

	public List<Metric> getMetrics() {
		return metrics;
	}
	public void setRelations(List<Relation> relations) {
		this.relations = relations;
	}	

	public List<Relation> getRelations() {
		return relations;
	}
	public void setProperties(List<Property> properties) {
		this.properties = properties;
	}	

	public List<Property> getProperties() {
		return properties;
	}

}
