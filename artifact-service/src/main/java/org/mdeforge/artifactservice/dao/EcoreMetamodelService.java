package org.mdeforge.artifactservice.dao;

import org.mdeforge.artifactservice.model.EcoreMetamodel;
import org.mdeforge.servicemodel.common.BusinessException;

import java.util.List;

public interface EcoreMetamodelService extends CRUDArtifactService<EcoreMetamodel>, MetricProvider, SimilarityService, ValidateService, ClusterService {

    List<EcoreMetamodel> findByURI(String URI);
    List<String> getNSUris(EcoreMetamodel ecoreMetamodel) throws BusinessException;
}
