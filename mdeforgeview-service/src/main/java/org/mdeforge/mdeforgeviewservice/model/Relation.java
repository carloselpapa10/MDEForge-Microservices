package org.mdeforge.mdeforgeviewservice.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection="Relations")
public class Relation {

    @Id
    private String id;
    private String name;

    @DBRef
    private Artifact fromArtifact;

    @DBRef
    private Artifact toArtifact;

    public Relation() {}

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

    public Artifact getFromArtifact() {
        return fromArtifact;
    }

    public void setFromArtifact(Artifact fromArtifact) {
        this.fromArtifact = fromArtifact;
    }

    public Artifact getToArtifact() {
        return toArtifact;
    }

    public void setToArtifact(Artifact toArtifact) {
        this.toArtifact = toArtifact;
    }
}
