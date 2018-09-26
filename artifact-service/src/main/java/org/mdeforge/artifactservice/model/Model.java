package org.mdeforge.artifactservice.model;

public class Model extends Artifact {

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
}
