package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.EcoreMetamodel;
import org.mdeforge.mdeforgeui.Model.User;
import org.mdeforge.mdeforgeui.Service.ArtifactService;
import org.mdeforge.mdeforgeui.Service.UserService;
import org.mdeforge.mdeforgeui.WebApi.EcoreMetamodelRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/private/EcoreMetamodel")
public class EcoreController extends ArtifactController<EcoreMetamodel>{

    @Autowired
    private ArtifactService artifactService;

    @Autowired
    private UserService userService;



    @PostMapping("/upload")
    public String uploadNewArtifact(Model model, EcoreMetamodel artifact, @RequestParam("artifactfile") MultipartFile file, @ModelAttribute("currentUser") User user){

        try{
            File fileToSend = convert(file);

            List<String> sharedList = new ArrayList<>();
            artifact.getShared().forEach(u ->{
                sharedList.add(u.getId());
            });

            EcoreMetamodelRequest request = new EcoreMetamodelRequest(artifact.getName(), artifact.getDescription(), artifact.isOpen(), file.getOriginalFilename(),
                    user.getId() != null ? user.getId() : userService.findUserByEmail(user.getEmail()).getId(), sharedList, artifact.getProperties());

            artifactService.createEcoreMetamodelArtifact(request, fileToSend);

        }catch (IOException e){
            return null;
        }

        return "redirect:/";
    }

    private File convert(MultipartFile file) throws IOException {
        File convFile = new File(file.getOriginalFilename());
        convFile.createNewFile();
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
