package org.mdeforge.mdeforgeviewservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.workspace.api.events.*;
import org.mdeforge.servicemodel.workspace.api.info.*;
import org.mdeforge.mdeforgeviewservice.dao.WorkspaceService;
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
public class WorkspaceServiceImpl implements WorkspaceService{

	private static final Logger log = LoggerFactory.getLogger(WorkspaceServiceImpl.class);

	@Autowired
	private WorkspaceRepository workspaceRepository;

	@Override
	public Workspace createWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createWorkspace(Workspace workspace) - WorkspaceServiceImpl - MdeforgeviewService");
		return workspace;
	}
				
	@Override
	public void updateWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateWorkspace(Workspace workspace) - WorkspaceServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void completeUpdateWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeUpdateWorkspace(Workspace workspace) - WorkspaceServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public Workspace findWorkspace(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findWorkspace(String id) - WorkspaceServiceImpl - MdeforgeviewService");
		return null;
	}
			
	@Override
	public void deleteWorkspace(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteWorkspace(String id) - WorkspaceServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void addProjectToWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addProjectToWorkspace(Workspace workspace) - WorkspaceServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void completeAddProjectToWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeAddProjectToWorkspace(Workspace workspace) - WorkspaceServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void removeProjectInWorkspace(Workspace workspace) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeProjectInWorkspace(Workspace workspace) - WorkspaceServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public List<Workspace> findAll() throws BusinessException{
		log.info("findAll() - WorkspaceServiceImpl - MdeforgeviewService");
		return workspaceRepository.findAll();
	}

}
