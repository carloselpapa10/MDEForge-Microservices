package org.mdeforge.projectservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.project.api.events.*;
import org.mdeforge.servicemodel.project.api.info.*;
import org.mdeforge.projectservice.dao.ProjectService;
import org.mdeforge.projectservice.model.*;
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
import org.mdeforge.projectservice.saga.addartifacttoproject.AddArtifactToProjectSagaData;
import org.mdeforge.projectservice.saga.adduserinproject.AddUserInProjectSagaData;
import io.eventuate.tram.sagas.orchestration.SagaManager;

@Component
@Transactional
public class ProjectServiceImpl implements ProjectService{

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ProjectDomainEventPublisher projectAggregateEventPublisher;

	@Autowired
	private SagaManager<AddArtifactToProjectSagaData> addArtifactToProjectSagaManager;

	@Autowired
	private SagaManager<AddUserInProjectSagaData> addUserInProjectSagaManager;

	@Override
	public Project createProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createProject(Project project) - ProjectServiceImpl - ProjectService");
		
		List<ProjectDomainEvent> events = singletonList(new ProjectCreatedEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		
		project = projectRepository.save(project);
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

		return project;
	}
				
	@Override
	public void updateProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateProject(Project project) - ProjectServiceImpl - ProjectService");

		List<ProjectDomainEvent> events = singletonList(new ProjectUpdatedEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

	}
			
	@Override
	public Project findProject(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findProject(String id) - ProjectServiceImpl - ProjectService");
		return null;
	}
			
	@Override
	public void deleteProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteProject(Project project) - ProjectServiceImpl - ProjectService");
		
		List<ProjectDomainEvent> events = singletonList(new ProjectDeletedEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);
		
		projectRepository.delete(project);
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);
		
	}
			
	@Override
	public void addArtifactToProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addArtifactToProject(Project project) - ProjectServiceImpl - ProjectService");

		AddArtifactToProjectSagaData data = new AddArtifactToProjectSagaData();
		addArtifactToProjectSagaManager.create(data);
		
	}
			
	@Override
	public void completeAddArtifactToProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeAddArtifactToProject(Project project) - ProjectServiceImpl - ProjectService");

		List<ProjectDomainEvent> events = singletonList(new AddedArtifactToProjectEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

	}
			
	@Override
	public void removeArtifactFromProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeArtifactFromProject(Project project) - ProjectServiceImpl - ProjectService");

		List<ProjectDomainEvent> events = singletonList(new RemovedArtifactFromProjectEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

	}
			
	@Override
	public void shareProjectToUser(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("shareProjectToUser(Project project) - ProjectServiceImpl - ProjectService");

		List<ProjectDomainEvent> events = singletonList(new SharedProjectWithUserEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

	}
			
	@Override
	public void addUserInProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addUserInProject(Project project) - ProjectServiceImpl - ProjectService");

		AddUserInProjectSagaData data = new AddUserInProjectSagaData();
		addUserInProjectSagaManager.create(data);
		
	}
			
	@Override
	public void completeAddUserInProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeAddUserInProject(Project project) - ProjectServiceImpl - ProjectService");

		List<ProjectDomainEvent> events = singletonList(new AddedUserInProjectEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

	}
			
	@Override
	public void removeUserFromProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeUserFromProject(Project project) - ProjectServiceImpl - ProjectService");

		List<ProjectDomainEvent> events = singletonList(new RemovedUserFromProjectEvent());
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

	}
			
	@Override
	public List<Project> findAll() throws BusinessException{
		log.info("findAll() - ProjectServiceImpl - ProjectService");
		return projectRepository.findAll();
	}
	
}
