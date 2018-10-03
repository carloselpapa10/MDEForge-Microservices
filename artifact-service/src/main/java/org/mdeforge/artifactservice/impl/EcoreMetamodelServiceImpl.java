package org.mdeforge.artifactservice.impl;

import org.mdeforge.artifactservice.dao.EcoreMetamodelService;
import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.artifactservice.model.EcoreMetamodel;
import org.mdeforge.artifactservice.model.EcoreMetamodelDomainEventPublisher;
import org.mdeforge.artifactservice.model.Metric;
import org.mdeforge.servicemodel.artifact.api.events.EcoreMetamodelCreatedEvent;
import org.mdeforge.servicemodel.artifact.api.events.EcoreMetamodelDomainEvent;
import org.mdeforge.servicemodel.artifact.api.info.EcoreMetamodelInfo;
import org.mdeforge.servicemodel.artifact.api.info.PropertyInfo;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import static java.util.Collections.singletonList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.ArrayList;
import java.util.NoSuchElementException;
import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;

import java.util.List;

@Service
public class EcoreMetamodelServiceImpl extends CRUDArtifactServiceImpl<EcoreMetamodel> implements EcoreMetamodelService {

    private static final Logger log = LoggerFactory.getLogger(EcoreMetamodelServiceImpl.class);

    @Autowired
    private EcoreMetamodelDomainEventPublisher ecoreMetamodelDomainEventPublisher;

    @Override
    public EcoreMetamodel create(EcoreMetamodel artifact, MultipartFile file) throws BusinessException {
        log.info("create(EcoreMetamodel artifact, MultipartFile file) - EcoreMetamodelServiceImpl - ArtifactService");

        EcoreMetamodel ecoreMetamodel = super.create(artifact, file);

        //result.setValid(isValid(result));
        //result.getUri().addAll(getNSUris(result));
        //result.setMetrics(calculateMetrics(result));

        EcoreMetamodelInfo ecoreMetamodelInfo = new EcoreMetamodelInfo();
        ecoreMetamodelInfo.setName(ecoreMetamodel.getName());
        ecoreMetamodelInfo.setDescription(ecoreMetamodel.getDescription());
        ecoreMetamodelInfo.setAuthor(ecoreMetamodel.getAuthor());
        ecoreMetamodelInfo.setFileName(ecoreMetamodel.getFileName());
        ecoreMetamodelInfo.setFileUrl(ecoreMetamodel.getFileUrl());
        ecoreMetamodelInfo.setGenerated(ecoreMetamodel.isGenerated());
        ecoreMetamodelInfo.setCreated(ecoreMetamodel.getCreated());
        ecoreMetamodelInfo.setModified(ecoreMetamodel.getModified());

        List<PropertyInfo> propertyInfoList = new ArrayList<>();
        ecoreMetamodel.getProperties().forEach(property -> {
            propertyInfoList.add(new PropertyInfo(property.getName(), property.getValue()));
        });

        ecoreMetamodelInfo.setPropertiesInfo(propertyInfoList);

        List<String> sharedUserListInfo = new ArrayList<>();
        ecoreMetamodel.getSharedUserList().forEach(shared -> {
            sharedUserListInfo.add(shared);
        });

        ecoreMetamodelInfo.setShareduserlist(sharedUserListInfo);

        List<EcoreMetamodelDomainEvent> events = singletonList(new EcoreMetamodelCreatedEvent(ecoreMetamodelInfo));
        ResultWithDomainEvents<EcoreMetamodel, EcoreMetamodelDomainEvent> ecoreMetamodelAndEvents = new ResultWithDomainEvents<>(ecoreMetamodel, events);

        ecoreMetamodel = artifactRepository.save(ecoreMetamodel);
        ecoreMetamodelDomainEventPublisher.publish(ecoreMetamodel, ecoreMetamodelAndEvents.events);

        return ecoreMetamodel;
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
