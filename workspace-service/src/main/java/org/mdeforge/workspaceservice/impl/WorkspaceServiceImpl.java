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

	@Override
	public Workspace createWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

		WorkspaceInfo workspaceInfo = new WorkspaceInfo(workspace.getName(), workspace.getDescription(), workspace.getOwner(), workspace.getProjects(), workspace.getState().toString());

		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceCreatedEvent(workspaceInfo));
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);		
		
		workspace = workspaceRepository.save(workspace);
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);

		/*notice that if projectList is empty it's not necessary make a saga*/
		if(workspace.getProjects() != null && workspace.getProjects().size() > 0){
			CreateWorkspaceSagaData data = new CreateWorkspaceSagaData(workspace.getId(), workspace.getOwner(), workspace.getProjects());
			createWorkspaceSagaManager.create(data, Workspace.class, workspace.getId());
		}
		
		return workspace;
	}
				
	@Override
	public Workspace updateWorkspace(Workspace modifiedWorkspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

		Workspace workspace = findWorkspace(modifiedWorkspace.getId());

		if(workspace==null){
		    return null;
        }

        modifiedWorkspace.setState(WorkspaceState.UPDATED);
        workspace = workspaceRepository.save(modifiedWorkspace);

        if(modifiedWorkspace.getProjects()!= null && modifiedWorkspace.getProjects().size() >0){

            UpdateWorkspaceSagaData data = new UpdateWorkspaceSagaData(workspace.getId(), workspace.getOwner(), workspace.getProjects());
            updateWorkspaceSagaManager.create(data);

        }else {
            completeUpdateWorkspace(workspace);
        }

		return workspace;
	}
			
	@Override
	public void completeUpdateWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeUpdateWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");

        WorkspaceInfo workspaceInfo = new WorkspaceInfo(workspace.getId(), workspace.getName(), workspace.getDescription(), workspace.getOwner(), workspace.getProjects(), workspace.getState().toString());

		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceUpdatedEvent(workspaceInfo));
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);		
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);
	}
			
	@Override
	public Workspace findWorkspace(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findWorkspace(String id) - WorkspaceServiceImpl - WorkspaceService");
		return workspaceRepository.findOne(id);
	}
			
	@Override
	public void deleteWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteWorkspace(Workspace workspace) - WorkspaceServiceImpl - WorkspaceService");
		
		List<WorkspaceDomainEvent> events = singletonList(new WorkspaceDeletedEvent(new WorkspaceInfo(workspace.getId())));
		ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);
		
		workspaceRepository.delete(workspace);
		workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);
	}
			
	@Override
	public Workspace addProjectToWorkspace(Workspace workspace, String projectId) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addProjectToWorkspace(Workspace workspace, String projectId) - WorkspaceServiceImpl - WorkspaceService");

        if(!workspace.getProjects().contains(projectId)){

            workspace.addProject(projectId);

            List<WorkspaceDomainEvent> events = singletonList(new AddedProjectToWorkspaceEvent(new WorkspaceInfo(workspace.getId()), projectId));
            ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);

            workspace = workspaceRepository.save(workspace);
            workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);
        }

		return workspace;
	}

	@Override
	public Workspace removeProjectInWorkspace(Workspace workspace, String projectId) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeProjectInWorkspace(Workspace workspace, String projectId) - WorkspaceServiceImpl - WorkspaceService");

        if(workspace.getProjects().contains(projectId)){
            workspace.removeProject(projectId);

            List<WorkspaceDomainEvent> events = singletonList(new RemovedProjectInWorkspace(new WorkspaceInfo(workspace.getId()), projectId));
            ResultWithDomainEvents<Workspace, WorkspaceDomainEvent> workspaceAndEvents = new ResultWithDomainEvents<>(workspace, events);
            workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);

            workspace = workspaceRepository.save(workspace);
            workspaceAggregateEventPublisher.publish(workspace, workspaceAndEvents.events);
        }

		return workspace;
	}
			
	@Override
	public List<Workspace> findAll() throws BusinessException{
		log.info("findAll() - WorkspaceServiceImpl - WorkspaceService");
		return workspaceRepository.findAll();
	}

	@Override
	public void saveWorkspace(Workspace workspace) throws BusinessException {
		log.info("saveWorkspace() - WorkspaceServiceImpl - WorkspaceService");
		workspaceRepository.save(workspace);
	}

}
