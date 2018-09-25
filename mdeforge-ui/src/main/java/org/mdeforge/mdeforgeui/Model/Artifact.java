package org.mdeforge.mdeforgeui.Model;

import org.springframework.web.multipart.MultipartFile;

import javax.validation.constraints.NotEmpty;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Artifact {

    private String id;
    private Date created;
    private Date modified;
    private boolean open;
    private String fileUrl;
    private MultipartFile file;
    private String name;
    private String description;
    private List<String> tags;
    private String authors;
    private String version;
    private String nameForIndex;
    private String descriptionForIndex;
    private String weightedContentsThree;
    private String weightedContentsTwo;
    private String weightedContentsOne;
    private String defaultWeightedContents;
    private User author;

    private List<Comment> comments = new ArrayList<Comment>();
    private List<Metric> metrics = new ArrayList<Metric>();
    private List<Relation> relations = new ArrayList<Relation>();
    private List<User> shared = new ArrayList<User>();
    private List<Property> properties = new ArrayList<>();

    public Artifact() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
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

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public List<User> getShared() {
        return shared;
    }

    public void setShared(List<User> shared) {
        this.shared = shared;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
