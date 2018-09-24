package org.mdeforge.mdeforgeviewservice.messaging;

import org.mdeforge.mdeforgeviewservice.dao.ProjectService;
import org.mdeforge.mdeforgeviewservice.dao.UserService;
import org.mdeforge.mdeforgeviewservice.dao.WorkspaceService;
import org.mdeforge.servicemodel.project.api.commands.ValidateProjectListCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.project.api.events.*;
import org.mdeforge.mdeforgeviewservice.impl.*;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProjectHistoryEventHandlers {
	
	private static final Logger log = LoggerFactory.getLogger(ProjectHistoryEventHandlers.class);

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	@Autowired
    private WorkspaceService workspaceService;

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.projectservice.model.Project")
				.onEvent(ProjectCreatedEvent.class, this::handleProjectCreatedEvent)
				.onEvent(ProjectUpdatedEvent.class, this::handleProjectUpdatedEvent)
				.onEvent(ProjectDeletedEvent.class, this::handleProjectDeletedEvent)
				.onEvent(RejectedAddProjectToWorkspaceEvent.class, this::handleRejectedAddProjectToWorkspaceEvent)
				.onEvent(EditedProjectsToWorkspaceCommand.class, this::handleEditedProjectsToWorkspaceCommand)
				.onEvent(RejectedEditProjectsToWorkspaceCommand.class, this::handleRejectedEditProjectsToWorkspaceCommand)
				.onEvent(AddedArtifactToProjectEvent.class, this::handleAddedArtifactToProjectEvent)
				.onEvent(SharedProjectWithUserEvent.class, this::handleSharedProjectWithUserEvent)
				.onEvent(RemovedArtifactFromProjectEvent.class, this::handleRemovedArtifactFromProjectEvent)
				.onEvent(AddedUserInProjectEvent.class, this::handleAddedUserInProjectEvent)
				.onEvent(RemovedUserFromProjectEvent.class, this::handleRemovedUserFromProjectEvent)
				.build();
	}

	private void handleProjectCreatedEvent(DomainEventEnvelope<ProjectCreatedEvent> dee) {
		log.info("handleProjectCreatedEvent() - ProjectHistoryEventHandlers - ProjectService");

		Project project = new Project(dee.getAggregateId(),
										dee.getEvent().getProjectInfo().getName(),
											dee.getEvent().getProjectInfo().getDescription(),
                                                dee.getEvent().getProjectInfo().isOpen(),
                                                    dee.getEvent().getProjectInfo().getState(),
                                                        userService.findUser(dee.getEvent().getProjectInfo().getOwner()));

		projectService.createProject(project);
	}

	private void handleProjectUpdatedEvent(DomainEventEnvelope<ProjectUpdatedEvent> dee) {
		log.info("handleProjectUpdatedEvent() - ProjectHistoryEventHandlers - ProjectService");

		Project project = projectService.findProject(dee.getAggregateId());
		project.setDescription(dee.getEvent().getProjectInfo().getDescription());
		project.setName(dee.getEvent().getProjectInfo().getName());
		project.setOwner(userService.findUser(dee.getEvent().getProjectInfo().getOwner()));
		project.setOpen(dee.getEvent().getProjectInfo().isOpen());
		project.setState(dee.getEvent().getProjectInfo().getState());

		projectService.updateProject(project);
	}

	private void handleProjectDeletedEvent(DomainEventEnvelope<ProjectDeletedEvent> dee) {
		log.info("handleProjectDeletedEvent() - ProjectHistoryEventHandlers - ProjectService");

		Project project = projectService.findProject(dee.getAggregateId());
		projectService.deleteProject(project);
	}

	private void handleRejectedAddProjectToWorkspaceEvent(DomainEventEnvelope<RejectedAddProjectToWorkspaceEvent> dee) {
		log.info("handleRejectedAddProjectToWorkspaceEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleEditedProjectsToWorkspaceCommand(DomainEventEnvelope<EditedProjectsToWorkspaceCommand> dee) {
		log.info("handleEditedProjectsToWorkspaceCommand() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleRejectedEditProjectsToWorkspaceCommand(DomainEventEnvelope<RejectedEditProjectsToWorkspaceCommand> dee) {
		log.info("handleRejectedEditProjectsToWorkspaceCommand() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleAddedArtifactToProjectEvent(DomainEventEnvelope<AddedArtifactToProjectEvent> dee) {
		log.info("handleAddedArtifactToProjectEvent() - ProjectHistoryEventHandlers - ProjectService");
	}

	private void handleSharedProjectWithUserEvent(DomainEventEnvelope<SharedProjectWithUserEvent> dee) {
		log.info("handleSharedProjectWithUserEvent() - ProjectHistoryEventHandlers - ProjectService");

		Project project = projectService.findProject(dee.getAggregateId());
		User user = userService.findUser(dee.getEvent().getUserId());

		if(user!= null && project != null){
			projectService.shareProjectToUser(project, user);
		}else{
			/* user or project do not exist - report it by log*/
			log.info("user or project do not exist!!!");
		}

	}

	private void handleRemovedArtifactFromProjectEvent(DomainEventEnvelope<RemovedArtifactFromProjectEvent> dee) {
		log.info("handleRemovedArtifactFromProjectEvent() - ProjectHistoryEventHandlers - ProjectService");

	}

	private void handleAddedUserInProjectEvent(DomainEventEnvelope<AddedUserInProjectEvent> dee) {
		log.info("handleAddedUserInProjectEvent() - ProjectHistoryEventHandlers - ProjectService");

		Project project = projectService.findProject(dee.getAggregateId());

		User user = userService.findUser(dee.getEvent().getUserId());

		if(user != null){

		    for(int index = 0; index < project.getUserlist().size(); index++){
		        if(project.getUserlist().get(index).getId().equals(user.getId())){
		            return;
                }
            }

            project.addUser(user);
		    projectService.save(project);

        }else {
            log.info("User was not found!");
        }

	}

    private void handleRemovedUserFromProjectEvent(DomainEventEnvelope<RemovedUserFromProjectEvent> dee) {
        log.info("handleRemovedUserFromProjectEvent() - ProjectHistoryEventHandlers - ProjectService");

        Project project = projectService.findProject(dee.getAggregateId());

        User user = userService.findUser(dee.getEvent().getUserId());

        if(user != null){

            for (int index=0; index < project.getUserlist().size(); index++){
                if(project.getUserlist().get(index).getId().equals(user.getId())){
                    project.removeUser(project.getUserlist().get(index));
                    projectService.save(project);
                    break;
                }
            }
        }else {
            log.info("User was not found!");
        }
    }

}
