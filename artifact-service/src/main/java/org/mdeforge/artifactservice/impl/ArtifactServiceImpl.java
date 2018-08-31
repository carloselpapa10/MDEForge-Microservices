package org.mdeforge.artifactservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.artifact.api.events.*;
import org.mdeforge.servicemodel.artifact.api.info.*;
import org.mdeforge.artifactservice.dao.ArtifactService;
import org.mdeforge.artifactservice.model.*;
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
	
	@Autowired
	private ArtifactDomainEventPublisher artifactAggregateEventPublisher;

	@Override
	public Artifact createArtifact(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createArtifact(Artifact artifact) - ArtifactServiceImpl - ArtifactService");
		
		List<ArtifactDomainEvent> events = singletonList(new ArtifactCreatedEvent());
		ResultWithDomainEvents<Artifact, ArtifactDomainEvent> artifactAndEvents = new ResultWithDomainEvents<>(artifact, events);		
		
		artifact = artifactRepository.save(artifact);
		artifactAggregateEventPublisher.publish(artifact, artifactAndEvents.events);

		return artifact;
	}
				
	@Override
	public void updateArtifact(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateArtifact(Artifact artifact) - ArtifactServiceImpl - ArtifactService");

		List<ArtifactDomainEvent> events = singletonList(new ArtifactUpdatedEvent());
		ResultWithDomainEvents<Artifact, ArtifactDomainEvent> artifactAndEvents = new ResultWithDomainEvents<>(artifact, events);		
		artifactAggregateEventPublisher.publish(artifact, artifactAndEvents.events);

	}
			
	@Override
	public Artifact findArtifact(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findArtifact(String id) - ArtifactServiceImpl - ArtifactService");
		return null;
	}
			
	@Override
	public void deleteArtifact(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteArtifact(Artifact artifact) - ArtifactServiceImpl - ArtifactService");
		
		List<ArtifactDomainEvent> events = singletonList(new ArtifactDeletedEvent());
		ResultWithDomainEvents<Artifact, ArtifactDomainEvent> artifactAndEvents = new ResultWithDomainEvents<>(artifact, events);
		
		artifactRepository.delete(artifact);
		artifactAggregateEventPublisher.publish(artifact, artifactAndEvents.events);
		
	}
			
	@Override
	public void shareArtifactToUser(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("shareArtifactToUser(Artifact artifact) - ArtifactServiceImpl - ArtifactService");

		List<ArtifactDomainEvent> events = singletonList(new SharedArtifactToUserEvent());
		ResultWithDomainEvents<Artifact, ArtifactDomainEvent> artifactAndEvents = new ResultWithDomainEvents<>(artifact, events);		
		artifactAggregateEventPublisher.publish(artifact, artifactAndEvents.events);

	}
			
	@Override
	public void changeArtifactOpen(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("changeArtifactOpen(Artifact artifact) - ArtifactServiceImpl - ArtifactService");

		List<ArtifactDomainEvent> events = singletonList(new ChangedArtifactOpenEvent());
		ResultWithDomainEvents<Artifact, ArtifactDomainEvent> artifactAndEvents = new ResultWithDomainEvents<>(artifact, events);		
		artifactAggregateEventPublisher.publish(artifact, artifactAndEvents.events);

	}
			
	@Override
	public void addArtifactToProjectList(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addArtifactToProjectList(Artifact artifact) - ArtifactServiceImpl - ArtifactService");

		List<ArtifactDomainEvent> events = singletonList(new AddedArtifactToProjectListEvent());
		ResultWithDomainEvents<Artifact, ArtifactDomainEvent> artifactAndEvents = new ResultWithDomainEvents<>(artifact, events);		
		artifactAggregateEventPublisher.publish(artifact, artifactAndEvents.events);

	}
			
	@Override
	public void removeArtifactToProjectList(Artifact artifact) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeArtifactToProjectList(Artifact artifact) - ArtifactServiceImpl - ArtifactService");

		List<ArtifactDomainEvent> events = singletonList(new RemovedArtifactToProjectListEvent());
		ResultWithDomainEvents<Artifact, ArtifactDomainEvent> artifactAndEvents = new ResultWithDomainEvents<>(artifact, events);		
		artifactAggregateEventPublisher.publish(artifact, artifactAndEvents.events);

	}
			
	@Override
	public List<Artifact> findAll() throws BusinessException{
		log.info("findAll() - ArtifactServiceImpl - ArtifactService");
		return artifactRepository.findAll();
	}
	
}
