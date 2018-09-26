package org.mdeforge.artifactservice.impl;

import org.mdeforge.artifactservice.dao.EcoreMetamodelService;
import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.artifactservice.model.EcoreMetamodel;
import org.mdeforge.artifactservice.model.Metric;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EcoreMetamodelServiceImpl extends CRUDArtifactServiceImpl<EcoreMetamodel> implements EcoreMetamodelService {

    @Override
    public EcoreMetamodel create(EcoreMetamodel artifact) throws BusinessException {
        EcoreMetamodel result = super.create(artifact);

        //result.setValid(isValid(result));
        //result.getUri().addAll(getNSUris(result));
        //result.setMetrics(calculateMetrics(result));

        return artifactRepository.save(result);
    }

    @Override
    public void createIndex(EcoreMetamodel artifact) {
        /*TODO*/
    }

    @Override
    public List<Metric> calculateMetrics(Artifact artifact) throws BusinessException {
        return null;
    }

    @Override
    public double calculateSimilarity(Artifact art1, Artifact art2) throws BusinessException {
        return 0;
    }

    @Override
    public boolean isValid(Artifact artifact) {
        return false;
    }

    @Override
    public List<EcoreMetamodel> findByURI(String URI) {
        return null;
    }

    @Override
    public List<String> getNSUris(EcoreMetamodel ecoreMetamodel) throws BusinessException {
        return null;
    }
}
