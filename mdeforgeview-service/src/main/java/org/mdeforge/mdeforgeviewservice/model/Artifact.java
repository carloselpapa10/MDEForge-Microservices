package org.mdeforge.mdeforgeviewservice.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Artifacts")
public class Artifact{

    private String id;
    private String name;
    private String description;
    private boolean open;
    private String fileUrl;
    private String fileName;
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

    @DBRef
    private User author;

    @DBRef
    private List<User> sharedUserList;
    private List<Comment> comments = new ArrayList<>();
    private List<Metric> metrics = new ArrayList<>();

    @DBRef(lazy = true)
    private List<Relation> relations = new ArrayList<>();
    private List<Property> properties = new ArrayList<>();

    public Artifact() {
    }

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

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getFileUrl() {
        return fileUrl;
    }

    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<User> getSharedUserList() {
        return sharedUserList;
    }

    public void setSharedUserList(List<User> sharedUserList) {
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
