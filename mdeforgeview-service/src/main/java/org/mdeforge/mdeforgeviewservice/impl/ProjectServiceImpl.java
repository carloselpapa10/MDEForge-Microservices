package org.mdeforge.mdeforgeviewservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.project.api.events.*;
import org.mdeforge.servicemodel.project.api.info.*;
import org.mdeforge.mdeforgeviewservice.dao.ProjectService;
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
public class ProjectServiceImpl implements ProjectService{

	private static final Logger log = LoggerFactory.getLogger(ProjectServiceImpl.class);

	@Autowired
	private ProjectRepository projectRepository;

	@Override
	public Project createProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("createProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
		return projectRepository.save(project);
	}
				
	@Override
	public void updateProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("updateProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
        projectRepository.save(project);
	}
			
	@Override
	public Project findProject(String id) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("findProject(String id) - ProjectServiceImpl - MdeforgeviewService");
		return projectRepository.findOne(id);
	}
			
	@Override
	public void deleteProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("deleteProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
		projectRepository.delete(project);
	}
			
	@Override
	public void addArtifactToProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addArtifactToProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void completeAddArtifactToProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeAddArtifactToProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void removeArtifactFromProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeArtifactFromProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public Project shareProjectToUser(Project project, User user) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("shareProjectToUser(Project project) - ProjectServiceImpl - MdeforgeviewService");

		List<User> userList = project.getUserlist() == null ? new ArrayList<>() : project.getUserlist();
		userList.add(user);
		project.setUserlist(userList);

		return projectRepository.save(project);
	}
			
	@Override
	public void addUserInProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("addUserInProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void completeAddUserInProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("completeAddUserInProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public void removeUserFromProject(Project project) throws BusinessException{
		// TODO Auto-generated method stub
		log.info("removeUserFromProject(Project project) - ProjectServiceImpl - MdeforgeviewService");
	}
			
	@Override
	public List<Project> findAll() throws BusinessException{
		log.info("findAll() - ProjectServiceImpl - MdeforgeviewService");
		return projectRepository.findAll();
	}

    @Override
    public void save(Project project) throws BusinessException {
        projectRepository.save(project);
    }

}
