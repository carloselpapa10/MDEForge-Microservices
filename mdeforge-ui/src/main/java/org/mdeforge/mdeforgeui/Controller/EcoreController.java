package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.EcoreMetamodel;
import org.mdeforge.mdeforgeui.Service.ArtifactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@Controller
@RequestMapping("/private/EcoreMetamodel")
public class EcoreController extends ArtifactController<EcoreMetamodel>{

    @Autowired
    private ArtifactService artifactService;

    @PostMapping("/upload")
    public String uploadNewArtifact(Model model, EcoreMetamodel artifact, @RequestParam("artifactfile") MultipartFile file){

        //artifact.setFile(file);
        try {
            MultiValueMap<String, Object> parameters = new LinkedMultiValueMap<String, Object>();
            //parameters.add("file", new FileSystemResource(file.get));


        }catch (Exception e){

        }
        artifactService.createEcoreMetamodelArtifact(artifact);

        return "redirect:/";
    }
}
