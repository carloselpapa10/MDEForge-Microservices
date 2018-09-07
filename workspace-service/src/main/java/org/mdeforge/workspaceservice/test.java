package org.mdeforge.workspaceservice;

import java.util.ArrayList;
import java.util.List;

public class test {

    public static void main(String[] args){

        List<proj>  projList = new ArrayList<>();

        proj p = new proj("1", "martha");

        projList.add(p);

        projList.remove(p);

        projList.forEach(proj -> {
            System.out.println(proj.getName());
        });

    }


}

class proj{

    private String id;
    private String name;

    public proj(String id, String name) {
        this.id = id;
        this.name = name;
    }

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
}
