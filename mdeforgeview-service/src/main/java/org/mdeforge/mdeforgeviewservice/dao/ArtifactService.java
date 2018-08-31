package org.mdeforge.mdeforgeviewservice.dao;

import java.util.List;
import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.mdeforgeviewservice.model.*;

public interface ArtifactService {

	public Artifact createArtifact(Artifact artifact) throws BusinessException;				
	public void updateArtifact(Artifact artifact) throws BusinessException;			
	public Artifact findArtifact(String id) throws BusinessException;			
	public void deleteArtifact(String id) throws BusinessException;			
	public void shareArtifactToUser(Artifact artifact) throws BusinessException;			
	public void changeArtifactOpen(Artifact artifact) throws BusinessException;			
	public void addArtifactToProjectList(Artifact artifact) throws BusinessException;			
	public void removeArtifactToProjectList(Artifact artifact) throws BusinessException;			
	public List<Artifact> findAll() throws BusinessException;

}	
