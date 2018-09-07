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
import io.eventuate.tram.events.aggregates.ResultWithDomainEvents;

@Component
@Transactional
public class ProjectServiceImpl implements ProjectService{

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectRepository projectRepository;
	
	@Autowired
	private ProjectDomainEventPublisher projectAggregateEventPublisher;

	@Override
	public Project createProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createProject(Project project) - ProjectServiceImpl - ProjectService");

		project.setState(ProjectState.CREATED);
		ProjectInfo projectInfo = new ProjectInfo(project.getName(), project.getDescription(), project.getOwner(), project.getState().toString());

		List<ProjectDomainEvent> events = singletonList(new ProjectCreatedEvent(projectInfo));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		
		project = projectRepository.save(project);
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

		return project;
	}
				
	@Override
	public Project updateProject(Project modifiedProject) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateProject(Project project) - ProjectServiceImpl - ProjectService");

		Project project = findProject(modifiedProject.getId());

		if(project==null) {
		    return null;
        }

        modifiedProject.setState(ProjectState.UPDATED);
		project = projectRepository.save(modifiedProject);

        ProjectInfo projectInfo = new ProjectInfo(project.getId(), project.getName(), project.getDescription(), project.getOwner(), project.getState().toString());

		List<ProjectDomainEvent> events = singletonList(new ProjectUpdatedEvent(projectInfo));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);		
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

		return project;
	}
			
	@Override
	public Project findProject(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findProject(String id) - ProjectServiceImpl - ProjectService");
		return projectRepository.findOne(id);
	}
			
	@Override
	public void deleteProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteProject(Project project) - ProjectServiceImpl - ProjectService");
		
		List<ProjectDomainEvent> events = singletonList(new ProjectDeletedEvent(new ProjectInfo(project.getId())));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);
		
		projectRepository.delete(project);
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);
		
	}
			
	@Override
	public void addArtifactToProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addArtifactToProject(Project project) - ProjectServiceImpl - ProjectService");
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
	public Project shareProjectToUser(Project project, String userId) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("shareProjectToUser(Project project) - ProjectServiceImpl - ProjectService");

		List<String> userList = project.getArtifactlist() == null ? new ArrayList<>() : project.getArtifactlist();

		if(userList.contains(userId)){
			return project; /*usedId already exists*/
		}

		userList.add(userId);
		project.setUserlist(userList);

		List<ProjectDomainEvent> events = singletonList(new SharedProjectWithUserEvent(new ProjectInfo(project.getId()), userId));
		ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);

		project = projectRepository.save(project);
		projectAggregateEventPublisher.publish(project, projectAndEvents.events);

		return project;
	}

	@Override
	public Project removeUserFromProject(Project project, String userId) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeUserFromProject(Project project) - ProjectServiceImpl - ProjectService");

		List<String> userList = project.getArtifactlist() == null ? new ArrayList<>() : project.getArtifactlist();

		if(userList.contains(userId)){

			userList.remove(userId);
			project.setUserlist(userList);

			List<ProjectDomainEvent> events = singletonList(new RemovedUserFromProjectEvent(new ProjectInfo(project.getId()), userId));
			ResultWithDomainEvents<Project, ProjectDomainEvent> projectAndEvents = new ResultWithDomainEvents<>(project, events);

			project = projectRepository.save(project);
			projectAggregateEventPublisher.publish(project, projectAndEvents.events);

			return project;

		}
		return null;
	}
			
	@Override
	public void addUserInProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addUserInProject(Project project) - ProjectServiceImpl - ProjectService");

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
	public List<Project> findAll() throws BusinessException{
		log.info("findAll() - ProjectServiceImpl - ProjectService");
		return projectRepository.findAll();
	}

	@Override
	public void saveProject(Project project) throws BusinessException {
		log.info("saveProject() - ProjectServiceImpl - ProjectService");
		projectRepository.save(project);
	}

}
