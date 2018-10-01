package org.mdeforge.mdeforgeviewservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.artifact.api.events.*;
import org.mdeforge.servicemodel.artifact.api.info.*;
import org.mdeforge.mdeforgeviewservice.dao.ArtifactService;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.mdeforge.mdeforgeviewservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import static java.util.Collections.singletonList;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;

@Component
@Transactional
public class ArtifactServiceImpl<T extends Artifact> implements ArtifactService<T>{

	private static final Logger log = LoggerFactory.getLogger(ArtifactServiceImpl.class);

	@Autowired
	private ArtifactRepository artifactRepository;

    @Override
    public T create(T artifact) throws BusinessException {
        return artifactRepository.save(artifact);
    }

    @Override
    public boolean existRelation(String idTo, String idFrom) throws BusinessException {
        return false;
    }

    @Override
    public void createIndex(Artifact artifact) throws BusinessException {

    }
}
