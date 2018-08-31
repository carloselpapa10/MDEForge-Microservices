package org.mdeforge.servicemodel.artifact.api.events;

import org.mdeforge.servicemodel.artifact.api.info.*;

public class ChangedArtifactOpenEvent implements ArtifactDomainEvent{
	
	private ArtifactInfo artifactInfo;
	private CommentInfo commentInfo;
	private MetricInfo metricInfo;
	private RelationInfo relationInfo;
	private PropertyInfo propertyInfo;
	private GridFileMediaInfo gridFileMediaInfo;

	public ChangedArtifactOpenEvent() {}

	public ChangedArtifactOpenEvent(ArtifactInfo artifactInfo) {
		super();
		this.artifactInfo = artifactInfo;
	}

	public ChangedArtifactOpenEvent(CommentInfo commentInfo) {
		super();
		this.commentInfo = commentInfo;
	}

	public ChangedArtifactOpenEvent(MetricInfo metricInfo) {
		super();
		this.metricInfo = metricInfo;
	}

	public ChangedArtifactOpenEvent(RelationInfo relationInfo) {
		super();
		this.relationInfo = relationInfo;
	}

	public ChangedArtifactOpenEvent(PropertyInfo propertyInfo) {
		super();
		this.propertyInfo = propertyInfo;
	}

	public ChangedArtifactOpenEvent(GridFileMediaInfo gridFileMediaInfo) {
		super();
		this.gridFileMediaInfo = gridFileMediaInfo;
	}

	
	public ArtifactInfo getArtifactInfo() {
		return artifactInfo;
	}

	public void setArtifactInfo(ArtifactInfo artifactInfo) {
		this.artifactInfo = artifactInfo;
	}

	
	public CommentInfo getCommentInfo() {
		return commentInfo;
	}

	public void setCommentInfo(CommentInfo commentInfo) {
		this.commentInfo = commentInfo;
	}

	
	public MetricInfo getMetricInfo() {
		return metricInfo;
	}

	public void setMetricInfo(MetricInfo metricInfo) {
		this.metricInfo = metricInfo;
	}

	
	public RelationInfo getRelationInfo() {
		return relationInfo;
	}

	public void setRelationInfo(RelationInfo relationInfo) {
		this.relationInfo = relationInfo;
	}

	
	public PropertyInfo getPropertyInfo() {
		return propertyInfo;
	}

	public void setPropertyInfo(PropertyInfo propertyInfo) {
		this.propertyInfo = propertyInfo;
	}

	
	public GridFileMediaInfo getGridFileMediaInfo() {
		return gridFileMediaInfo;
	}

	public void setGridFileMediaInfo(GridFileMediaInfo gridFileMediaInfo) {
		this.gridFileMediaInfo = gridFileMediaInfo;
	}

}
