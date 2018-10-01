package org.mdeforge.mdeforgeviewservice.model;

import org.springframework.data.annotation.Id;

public class Comment {

    @Id
    private String id;
    private String comment;
    private int star;
    private String user;

    public Comment() {}

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getStar() {
        return star;
    }

    public void setStar(int star) {
        this.star = star;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
