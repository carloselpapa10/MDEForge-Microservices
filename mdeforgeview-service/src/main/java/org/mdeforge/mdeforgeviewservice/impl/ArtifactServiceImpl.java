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
public class ArtifactServiceImpl implements ArtifactService{

	private static final Logger log = LoggerFactory.getLogger(ArtifactServiceImpl.class);

	@Autowired
	private ArtifactRepository artifactRepository;

	@Override
	public Artifact createArtifact(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createArtifact(Artifact artifact) - ArtifactServiceImpl - MdeforgeviewService");
		return artifact;
	}
				
	@Override
	public void updateArtifact(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateArtifact(Artifact artifact) - ArtifactServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public Artifact findArtifact(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findArtifact(String id) - ArtifactServiceImpl - MdeforgeviewService");
		return null;
	}
			
	@Override
	public void deleteArtifact(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteArtifact(String id) - ArtifactServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void shareArtifactToUser(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("shareArtifactToUser(Artifact artifact) - ArtifactServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void changeArtifactOpen(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("changeArtifactOpen(Artifact artifact) - ArtifactServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void addArtifactToProjectList(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addArtifactToProjectList(Artifact artifact) - ArtifactServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void removeArtifactToProjectList(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeArtifactToProjectList(Artifact artifact) - ArtifactServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public List<Artifact> findAll() throws BusinessException{
		log.info("findAll() - ArtifactServiceImpl - MdeforgeviewService");
		return artifactRepository.findAll();
	}

}
