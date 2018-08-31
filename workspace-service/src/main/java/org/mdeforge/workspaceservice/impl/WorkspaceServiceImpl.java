package org.mdeforge.workspaceservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.workspace.api.events.*;
import org.mdeforge.servicemodel.workspace.api.info.*;
import org.mdeforge.workspaceservice.dao.WorkspaceService;
import org.mdeforge.workspaceservice.model.*;
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
import org.mdeforge.workspaceservice.saga.createworkspace.CreateWorkspaceSagaData;
import org.mdeforge.workspaceservice.saga.updateworkspace.UpdateWorkspaceSagaData;
import org.mdeforge.workspaceservice.saga.addprojecttoworkspace.AddProjectToWorkspaceSagaData;
import io.eventuate.tram.sagas.orchestration.SagaManager;

@Component
@Transactional
public class WorkspaceServiceImpl implements WorkspaceService{

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceImpl.class);

	@Autowired
	private WorkspaceRepository workspaceRepository;
	
	@Autowired
	private WorkspaceDomainEventPublisher workspaceAggregateEventPublisher;

	@Autowired
	private SagaManager<CreateWorkspaceSagaData> createWorkspaceSagaManager;

	@Autowired
	private SagaManager<UpdateWorkspaceSagaData> updateWorkspaceSagaManager;

	@Autowired
	private SagaManager<AddProjectToWorkspaceSagaData> addProjectToWorkspaceSagaManager;

	@Override
	public Workspace createWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");
		
		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceCreatedEvent());
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);		
		
		workspace = workspaceRepository.save(workspace);
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);

		CreateWorkspaceSagaData data = new CreateWorkspaceSagaData();
		createWorkspaceSagaManager.create(data, Workspace.class, workspace.getId());
		
		return workspace;
	}
				
	@Override
	public void updateWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

		UpdateWorkspaceSagaData data = new UpdateWorkspaceSagaData();
		updateWorkspaceSagaManager.create(data);
		
	}
			
	@Override
	public void completeUpdateWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeUpdateWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceUpdatedEvent());
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);		
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);

	}
			
	@Override
	public Workspace findWorkspace(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findWorkspace(String id) - WorkspaceServiceImpl - WorkspaceService");
		return null;
	}
			
	@Override
	public void deleteWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");
		
		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceDeletedEvent());
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);
		
		workspaceRepository.delete(workspace);
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);
		
	}
			
	@Override
	public void addProjectToWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addProjectToWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

		AddProjectToWorkspaceSagaData data = new AddProjectToWorkspaceSagaData();
		addProjectToWorkspaceSagaManager.create(data);
		
	}
			
	@Override
	public void completeAddProjectToWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeAddProjectToWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

		List<WorkspaceDomainEvent> events = singletonList(new AddedProjectToWorkspaceEvent());
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);		
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);

	}
			
	@Override
	public void removeProjectInWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeProjectInWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

		List<WorkspaceDomainEvent> events = singletonList(new RemovedProjectInWorkspace());
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);		
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);

	}
			
	@Override
	public List<Workspace> findAll() throws BusinessException{
		log.info("findAll() - WorkspaceServiceImpl - WorkspaceService");
		return workspaceRepository.findAll();
	}
	
}
