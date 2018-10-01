package org.mdeforge.mdeforgeviewservice.dao;

import org.mdeforge.mdeforgeviewservice.model.EcoreMetamodel;
import org.mdeforge.servicemodel.common.BusinessException;

import java.util.List;

public interface EcoreMetamodelService extends ArtifactService<EcoreMetamodel>{

    List<EcoreMetamodel> findByURI(String URI);
    List<String> getNSUris(EcoreMetamodel ecoreMetamodel) throws BusinessException;
}
