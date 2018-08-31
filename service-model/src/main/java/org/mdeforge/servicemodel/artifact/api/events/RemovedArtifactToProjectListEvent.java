package org.mdeforge.servicemodel.artifact.api.events;

import org.mdeforge.servicemodel.artifact.api.info.*;

public class RemovedArtifactToProjectListEvent implements ArtifactDomainEvent{
	
	private ArtifactInfo artifactInfo;
	private CommentInfo commentInfo;
	private MetricInfo metricInfo;
	private RelationInfo relationInfo;
	private PropertyInfo propertyInfo;
	private GridFileMediaInfo gridFileMediaInfo;

	public RemovedArtifactToProjectListEvent() {}

	public RemovedArtifactToProjectListEvent(ArtifactInfo artifactInfo) {
		super();
		this.artifactInfo = artifactInfo;
	}

	public RemovedArtifactToProjectListEvent(CommentInfo commentInfo) {
		super();
		this.commentInfo = commentInfo;
	}

	public RemovedArtifactToProjectListEvent(MetricInfo metricInfo) {
		super();
		this.metricInfo = metricInfo;
	}

	public RemovedArtifactToProjectListEvent(RelationInfo relationInfo) {
		super();
		this.relationInfo = relationInfo;
	}

	public RemovedArtifactToProjectListEvent(PropertyInfo propertyInfo) {
		super();
		this.propertyInfo = propertyInfo;
	}

	public RemovedArtifactToProjectListEvent(GridFileMediaInfo gridFileMediaInfo) {
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
