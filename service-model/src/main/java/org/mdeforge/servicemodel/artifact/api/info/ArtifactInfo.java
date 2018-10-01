package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArtifactInfo {

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
	private List<CommentInfo> commentsInfo = new ArrayList<>();							
	private List<MetricInfo> metricsInfo = new ArrayList<>();							
	private List<RelationInfo> relationsInfo = new ArrayList<>();							
	private List<PropertyInfo> propertiesInfo = new ArrayList<>();							

	public ArtifactInfo(){}

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

    public String getNameforindex() {
        return nameforindex;
    }

    public void setNameforindex(String nameforindex) {
        this.nameforindex = nameforindex;
    }

    public String getDescriptionforindex() {
        return descriptionforindex;
    }

    public void setDescriptionforindex(String descriptionforindex) {
        this.descriptionforindex = descriptionforindex;
    }

    public String getWeightedcontentsthree() {
        return weightedcontentsthree;
    }

    public void setWeightedcontentsthree(String weightedcontentsthree) {
        this.weightedcontentsthree = weightedcontentsthree;
    }

    public String getWeightedcontentstwo() {
        return weightedcontentstwo;
    }

    public void setWeightedcontentstwo(String weightedcontentstwo) {
        this.weightedcontentstwo = weightedcontentstwo;
    }

    public String getWeightedcontentsone() {
        return weightedcontentsone;
    }

    public void setWeightedcontentsone(String weightedcontentsone) {
        this.weightedcontentsone = weightedcontentsone;
    }

    public String getDefaultweightedcontents() {
        return defaultweightedcontents;
    }

    public void setDefaultweightedcontents(String defaultweightedcontents) {
        this.defaultweightedcontents = defaultweightedcontents;
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

    public List<String> getProjectlist() {
        return projectlist;
    }

    public void setProjectlist(List<String> projectlist) {
        this.projectlist = projectlist;
    }

    public List<String> getShareduserlist() {
        return shareduserlist;
    }

    public void setShareduserlist(List<String> shareduserlist) {
        this.shareduserlist = shareduserlist;
    }

    public List<CommentInfo> getCommentsInfo() {
        return commentsInfo;
    }

    public void setCommentsInfo(List<CommentInfo> commentsInfo) {
        this.commentsInfo = commentsInfo;
    }

    public List<MetricInfo> getMetricsInfo() {
        return metricsInfo;
    }

    public void setMetricsInfo(List<MetricInfo> metricsInfo) {
        this.metricsInfo = metricsInfo;
    }

    public List<RelationInfo> getRelationsInfo() {
        return relationsInfo;
    }

    public void setRelationsInfo(List<RelationInfo> relationsInfo) {
        this.relationsInfo = relationsInfo;
    }

    public List<PropertyInfo> getPropertiesInfo() {
        return propertiesInfo;
    }

    public void setPropertiesInfo(List<PropertyInfo> propertiesInfo) {
        this.propertiesInfo = propertiesInfo;
    }
}
