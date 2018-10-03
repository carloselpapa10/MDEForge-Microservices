package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Model;
import org.mdeforge.mdeforgeui.Model.ModelForm;
import org.mdeforge.mdeforgeui.Model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/private/Model")
public class ModelController extends ArtifactController<Model>{

    @PostMapping("/upload")
    public String uploadNewArtifact(org.springframework.ui.Model model, @ModelAttribute ("artifact") ModelForm modelIn, @RequestParam("artifactfile") MultipartFile file, @ModelAttribute("currentUser") User user){

        /*TODO complete create model workflow*/

        return "redirect:/";
    }
}
