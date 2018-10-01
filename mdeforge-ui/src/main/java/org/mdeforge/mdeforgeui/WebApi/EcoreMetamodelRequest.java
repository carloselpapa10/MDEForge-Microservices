package org.mdeforge.mdeforgeui.WebApi;

import org.mdeforge.mdeforgeui.Model.Property;

import java.util.ArrayList;
import java.util.List;

public class EcoreMetamodelRequest {

    private String name;
    private String description;
    private boolean open;
    private String fileName;
    private String author;
    private List<String> sharedUserList;
    private List<Property> properties = new ArrayList<>();

    public EcoreMetamodelRequest(String name, String description, boolean open, String fileName, String author, List<String> sharedUserList, List<Property> properties) {
        this.name = name;
        this.description = description;
        this.open = open;
        this.fileName = fileName;
        this.author = author;
        this.sharedUserList = sharedUserList;
        this.properties = properties;
    }

    public EcoreMetamodelRequest() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public List<String> getSharedUserList() {
        return sharedUserList;
    }

    public void setSharedUserList(List<String> sharedUserList) {
        this.sharedUserList = sharedUserList;
    }

    public List<Property> getProperties() {
        return properties;
    }

    public void setProperties(List<Property> properties) {
        this.properties = properties;
    }
}
