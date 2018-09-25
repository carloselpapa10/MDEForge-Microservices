package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Artifact;
import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.ProjectService;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.lang.reflect.ParameterizedType;

public abstract class ArtifactController <T extends Artifact> {

    @Autowired
    private UserService userService;

    @Autowired
    private ProjectService projectService;

    private Class<T> clazz;

    public ArtifactController() {
        this.clazz = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @GetMapping("/upload")
    public String uploadArtifactView(@ModelAttribute("currentUser") User user, Model model) throws IllegalAccessException, InstantiationException {

        T emm;
        emm = clazz.newInstance();

        model.addAttribute("artifact", emm);
        model.addAttribute("projectList", projectService.findProjectListByUserEmail(user.getEmail()));
        model.addAttribute("userList", userService.findAllUsers());

        return "private/artifact/upload";
    }

}
