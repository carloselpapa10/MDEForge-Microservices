package org.mdeforge.mdeforgeui.Controller;

import org.mdeforge.mdeforgeui.Model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/private/Model")
public class ModelController extends ArtifactController<Model>{
}
