package org.mdeforge.projectservice.webapi;

public class ShareProjectToUserRequest {

    private String projectId;
    private String userId;

    public ShareProjectToUserRequest() {
    }

    public ShareProjectToUserRequest(String projectId, String userId) {
        this.projectId = projectId;
        this.userId = userId;
    }

    public String getProjectId() {
        return projectId;
    }

    public void setProjectId(String projectId) {
        this.projectId = projectId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}
