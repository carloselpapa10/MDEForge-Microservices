package org.mdeforge.artifactservice.dao;

import org.mdeforge.artifactservice.model.Artifact;

public interface ValidateService {

    boolean isValid(Artifact artifact);
}
