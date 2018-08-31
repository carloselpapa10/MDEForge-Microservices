package org.mdeforge.mdeforgeviewservice.dao;

import java.util.List;
import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.mdeforgeviewservice.model.*;

public interface ProjectService {

	public Project createProject(Project project) throws BusinessException;				
	public void updateProject(Project project) throws BusinessException;			
	public Project findProject(String id) throws BusinessException;			
	public void deleteProject(String id) throws BusinessException;			
	public void addArtifactToProject(Project project) throws BusinessException;			
	public void completeAddArtifactToProject(Project project) throws BusinessException;			
	public void removeArtifactFromProject(Project project) throws BusinessException;			
	public void shareProjectToUser(Project project) throws BusinessException;			
	public void addUserInProject(Project project) throws BusinessException;			
	public void completeAddUserInProject(Project project) throws BusinessException;			
	public void removeUserFromProject(Project project) throws BusinessException;			
	public List<Project> findAll() throws BusinessException;

}	
