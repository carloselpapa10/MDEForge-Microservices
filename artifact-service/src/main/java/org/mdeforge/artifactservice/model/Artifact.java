package org.mdeforge.artifactservice.model;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Artifacts")
public class Artifact{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)						
	private String id; 
    private String name;									
    private String description;									
    private boolean open;
    private String fileUrl;
    @DBRef(lazy = true)
    private File file;
    private boolean generated;									
    private Date created;
    private Date modified;
    private String authors;									
    private String version;									
    private String nameForIndex;
    private String descriptionForIndex;
    private String weightedContentsThree;
    private String weightedContentsTwo;
    private String weightedContentsOne;
    private String defaultWeightedContents;
	private List<String> tags;							
    private String author;
	private List<String> sharedUserList;
	private List<Comment> comments = new ArrayList<>();							
	private List<Metric> metrics = new ArrayList<>();

	@DBRef(lazy = true)
	private List<Relation> relations = new ArrayList<>();							
	private List<Property> properties = new ArrayList<>();							
				
	public Artifact() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpen() {
        return open;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isGenerated() {
        return generated;
    }

    public void setGenerated(boolean generated) {
        this.generated = generated;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getAuthors() {
        return authors;
    }

    public void setAuthors(String authors) {
        this.authors = authors;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getNameForIndex() {
        return nameForIndex;
    }

    public void setNameForIndex(String nameForIndex) {
        this.nameForIndex = nameForIndex;
    }

    public String getDescriptionForIndex() {
        return descriptionForIndex;
    }

    public void setDescriptionForIndex(String descriptionForIndex) {
        this.descriptionForIndex = descriptionForIndex;
    }

    public String getWeightedContentsThree() {
        return weightedContentsThree;
    }

    public void setWeightedContentsThree(String weightedContentsThree) {
        this.weightedContentsThree = weightedContentsThree;
    }

    public String getWeightedContentsTwo() {
        return weightedContentsTwo;
    }

    public void setWeightedContentsTwo(String weightedContentsTwo) {
        this.weightedContentsTwo = weightedContentsTwo;
    }

    public String getWeightedContentsOne() {
        return weightedContentsOne;
    }

    public void setWeightedContentsOne(String weightedContentsOne) {
        this.weightedContentsOne = weightedContentsOne;
    }

    public String getDefaultWeightedContents() {
        return defaultWeightedContents;
    }

    public void setDefaultWeightedContents(String defaultWeightedContents) {
        this.defaultWeightedContents = defaultWeightedContents;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getSharedUserList() {
        return sharedUserList;
    }

    public void setSharedUserList(List<String> sharedUserList) {
        this.sharedUserList = sharedUserList;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<Metric> getMetrics() {
        return metrics;
    }

    public void setMetrics(List<Metric> metrics) {
        this.metrics = metrics;
    }

    public List<Relation> getRelations() {
        return relations;
    }

    public void setRelations(List<Relation> relations) {
        this.relations = relations;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
