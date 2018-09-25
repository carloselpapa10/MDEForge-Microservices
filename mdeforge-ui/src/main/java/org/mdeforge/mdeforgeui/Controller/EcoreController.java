package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.EcoreMetamodel;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/private/EcoreMetamodel")
public class EcoreController extends ArtifactController<EcoreMetamodel>{

    //@RequestParam("artifactfile") MultipartFile file
    @PostMapping("/upload")
    public String uploadNewArtifact(Model model, EcoreMetamodel artifact, BindingResult result){


        return "redirect:/";
    }
}
