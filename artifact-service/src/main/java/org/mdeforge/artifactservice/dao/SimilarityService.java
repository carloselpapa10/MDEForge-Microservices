package org.mdeforge.artifactservice.dao;

import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.servicemodel.common.BusinessException;

public interface SimilarityService {

    double calculateSimilarity(Artifact art1, Artifact art2) throws BusinessException;
}
