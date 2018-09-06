package org.mdeforge.mdeforgeviewservice.messaging;

import io.eventuate.tram.events.common.DomainEvent;
import org.mdeforge.mdeforgeviewservice.dao.ProjectService;
import org.mdeforge.mdeforgeviewservice.dao.UserService;
import org.mdeforge.mdeforgeviewservice.dao.WorkspaceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.mdeforge.servicemodel.workspace.api.events.*;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;

import java.util.ArrayList;
import java.util.List;

@Component
public class WorkspaceHistoryEventHandlers {
	
	private static final Logger log = LoggerFactory.getLogger(WorkspaceHistoryEventHandlers.class);

	@Autowired
	private WorkspaceService workspaceService;

	@Autowired
	private ProjectService projectService;

	@Autowired
	private UserService userService;

	public DomainEventHandlers domainEventHandlers() {
		return DomainEventHandlersBuilder
				.forAggregateType("org.mdeforge.workspaceservice.model.Workspace")
				.onEvent(WorkspaceCreatedEvent.class, this::handleWorkspaceCreatedEvent)
				.onEvent(WorkspaceUpdatedEvent.class, this::handleWorkspaceUpdatedEvent)
				.onEvent(WorkspaceDeletedEvent.class, this::handleWorkspaceDeletedEvent)
                .onEvent(WorkspaceCreationRejectedEvent.class, this::handleWorkspaceCreationRejectedEvent)
                .onEvent(WorkspaceCreationCompletedEvent.class, this::handleWorkspaceCreationCompletedEvent)
				.onEvent(AddedProjectToWorkspaceEvent.class, this::handleAddedProjectToWorkspaceEvent)
				.onEvent(RemovedProjectInWorkspace.class, this::handleRemovedProjectInWorkspace)
				.build();
	}

    private void handleWorkspaceCreatedEvent(DomainEventEnvelope<WorkspaceCreatedEvent> dee) {
		log.info("handleWorkspaceCreatedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");

		List<Project> projectList = new ArrayList<>();

		dee.getEvent().getWorkspaceInfo().getProjects().forEach(projectId -> {
			projectList.add(projectService.findProject(projectId));
		});

		User user = userService.findUser(dee.getEvent().getWorkspaceInfo().getOwner());

		Workspace workspace = new Workspace(dee.getAggregateId(), dee.getEvent().getWorkspaceInfo().getName(),
												dee.getEvent().getWorkspaceInfo().getDescription(),  user,
															projectList, dee.getEvent().getWorkspaceInfo().getState());

		workspaceService.createWorkspace(workspace);
	}

	private void handleWorkspaceUpdatedEvent(DomainEventEnvelope<WorkspaceUpdatedEvent> dee) {
		log.info("handleWorkspaceUpdatedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");

        List<Project> projectList = new ArrayList<>();

        dee.getEvent().getWorkspaceInfo().getProjects().forEach(projectId -> {
            projectList.add(projectService.findProject(projectId));
        });

        User user = userService.findUser(dee.getEvent().getWorkspaceInfo().getOwner());

        Workspace workspace = workspaceService.findWorkspace(dee.getAggregateId());
        workspace.setName(dee.getEvent().getWorkspaceInfo().getName());
        workspace.setDescription(dee.getEvent().getWorkspaceInfo().getDescription());
        workspace.setOwner(user);
        workspace.setProjects(projectList);
        workspace.setState(dee.getEvent().getWorkspaceInfo().getState());

        workspaceService.save(workspace);
	}

	private void handleWorkspaceDeletedEvent(DomainEventEnvelope<WorkspaceDeletedEvent> dee) {
		log.info("handleWorkspaceDeletedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");

		Workspace workspace = workspaceService.findWorkspace(dee.getAggregateId());
		workspaceService.deleteWorkspace(workspace);
	}

    private void handleWorkspaceCreationRejectedEvent(DomainEventEnvelope<WorkspaceCreationRejectedEvent> dee) {
        log.info("handleWorkspaceCreationRejectedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");

        Workspace workspace = workspaceService.findWorkspace(dee.getAggregateId());
        workspace.setState(dee.getEvent().getWorkspaceInfo().getState());
        workspaceService.save(workspace);
    }

    private void handleWorkspaceCreationCompletedEvent(DomainEventEnvelope<WorkspaceCreationCompletedEvent> dee) {
        log.info("handleWorkspaceCreationCompletedEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");

        Workspace workspace = workspaceService.findWorkspace(dee.getAggregateId());
        workspace.setState(dee.getEvent().getWorkspaceInfo().getState());
        workspaceService.save(workspace);
    }

	private void handleAddedProjectToWorkspaceEvent(DomainEventEnvelope<AddedProjectToWorkspaceEvent> dee) {
		log.info("handleAddedProjectToWorkspaceEvent() - WorkspaceHistoryEventHandlers - WorkspaceService");
	}

	private void handleRemovedProjectInWorkspace(DomainEventEnvelope<RemovedProjectInWorkspace> dee) {
		log.info("handleRemovedProjectInWorkspace() - WorkspaceHistoryEventHandlers - WorkspaceService");
	}

}
