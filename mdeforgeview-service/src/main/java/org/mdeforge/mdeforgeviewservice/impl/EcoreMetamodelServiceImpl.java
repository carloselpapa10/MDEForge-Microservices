package org.mdeforge.mdeforgeviewservice.impl;

import org.mdeforge.mdeforgeviewservice.dao.EcoreMetamodelService;
import org.mdeforge.mdeforgeviewservice.model.EcoreMetamodel;
import org.mdeforge.mdeforgeviewservice.model.User;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EcoreMetamodelServiceImpl extends ArtifactServiceImpl<EcoreMetamodel> implements EcoreMetamodelService {

    @Override
    public List<EcoreMetamodel> findByURI(String URI) {
        return null;
    }

    @Override
    public List<String> getNSUris(EcoreMetamodel ecoreMetamodel) throws BusinessException {
        return null;
    }

    @Override
    public List<EcoreMetamodel> findAll(User user) {
        return findMyArtifacts(user);
    }

}
