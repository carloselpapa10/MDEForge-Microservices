package org.mdeforge.mdeforgeui.Model;

import com.fasterxml.jackson.annotation.JsonIdentityReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Model extends Artifact{

    private boolean valid;
    private String nsuri;
    private String uri;

    public boolean isValid() {
        return valid;
    }

    public void setValid(boolean valid) {
        this.valid = valid;
    }

    public String getNsuri() {
        return nsuri;
    }

    public void setNsuri(String nsuri) {
        this.nsuri = nsuri;
    }

    public String getUri() {
        return uri;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    @Override
    public String toString() {
        return "Model";
    }

    @JsonIgnore
    public ConformToRelation getMetamodel() {
        for (Relation rel : this.getRelations()) {
            if (rel instanceof ConformToRelation)
                return (ConformToRelation) rel;
        }
        return null;
    }

    @JsonIdentityReference
    public Artifact getMetamodelArtifact() {
        for (Relation rel : this.getRelations()) {
            if (rel instanceof ConformToRelation)
                return rel.getToArtifact();
        }
        return null;
    }
}
