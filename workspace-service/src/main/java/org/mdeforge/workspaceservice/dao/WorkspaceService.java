package org.mdeforge.workspaceservice.dao;

import java.util.List;
import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.workspaceservice.model.*;

public interface WorkspaceService {

	public Workspace createWorkspace(Workspace workspace) throws BusinessException;				
	public void updateWorkspace(Workspace workspace) throws BusinessException;			
	public void completeUpdateWorkspace(Workspace workspace) throws BusinessException;			
	public Workspace findWorkspace(String id) throws BusinessException;			
	public void deleteWorkspace(Workspace workspace) throws BusinessException;			
	public void addProjectToWorkspace(Workspace workspace) throws BusinessException;			
	public void completeAddProjectToWorkspace(Workspace workspace) throws BusinessException;			
	public void removeProjectInWorkspace(Workspace workspace) throws BusinessException;			
	public List<Workspace> findAll() throws BusinessException;
}		   
