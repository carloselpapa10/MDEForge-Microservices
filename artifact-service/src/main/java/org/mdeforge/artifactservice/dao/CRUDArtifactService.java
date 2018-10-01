package org.mdeforge.artifactservice.dao;

import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface CRUDArtifactService <T extends Artifact>{

    T create(T artifact, MultipartFile file) throws BusinessException;
    boolean existRelation(String idTo, String idFrom) throws BusinessException;
    void createIndex(T artifact) throws BusinessException;
}
