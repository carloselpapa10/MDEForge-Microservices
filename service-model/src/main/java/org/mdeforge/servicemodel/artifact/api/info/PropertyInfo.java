package org.mdeforge.servicemodel.artifact.api.info;

import java.util.ArrayList;
import java.util.List;

public class PropertyInfo {

    private String name;									
    private String value;									

	public PropertyInfo(){}

    public PropertyInfo(String name, String value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
