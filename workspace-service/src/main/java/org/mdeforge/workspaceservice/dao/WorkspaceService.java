package org.mdeforge.workspaceservice.dao;

import java.util.List;
import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.workspaceservice.model.*;

public interface WorkspaceService {

	public Workspace createWorkspace(Workspace workspace) throws BusinessException;				
	public Workspace updateWorkspace(Workspace workspace) throws BusinessException;
	public void completeUpdateWorkspace(Workspace workspace) throws BusinessException;			
	public Workspace findWorkspace(String id) throws BusinessException;			
	public void deleteWorkspace(Workspace workspace) throws BusinessException;			
	public Workspace addProjectToWorkspace(Workspace workspace, String projectId) throws BusinessException;
	public Workspace removeProjectInWorkspace(Workspace workspace, String projectId) throws BusinessException;
	public List<Workspace> findAll() throws BusinessException;

	public void removeProjectInAllWorkspaces(String projectId) throws BusinessException;
	public void saveWorkspace(Workspace workspace) throws BusinessException;
}		   
