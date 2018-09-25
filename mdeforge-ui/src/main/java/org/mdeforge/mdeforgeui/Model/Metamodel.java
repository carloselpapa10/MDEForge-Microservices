package org.mdeforge.mdeforgeui.Model;

import java.util.ArrayList;
import java.util.List;

public class Metamodel extends Artifact{

    private List<String> uri = new ArrayList<>();

    @Override
    public String toString() {
        return "Metamodel";
    }

    public List<String> getUri() {
        return uri;
    }

    public void setUri(List<String> uri) {
        this.uri = uri;
    }
}
