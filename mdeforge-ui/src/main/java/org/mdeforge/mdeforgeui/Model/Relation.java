package org.mdeforge.mdeforgeui.Model;

public class Relation {

    private String id = null;
    private String name = null;
    private Artifact toArtifact;
    private Artifact fromArtifact;

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

    public Artifact getToArtifact() {
        return toArtifact;
    }

    public void setToArtifact(Artifact toArtifact) {
        this.toArtifact = toArtifact;
    }

    public Artifact getFromArtifact() {
        return fromArtifact;
    }

    public void setFromArtifact(Artifact fromArtifact) {
        this.fromArtifact = fromArtifact;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }

        Relation other = (Relation) obj;
        return this.id.equals(other.id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }

    @Override
    public String toString() {
        return "Relation " + " [name: " + getName() + "]" + " [id: " + getId()
                + "]";
    }
}
