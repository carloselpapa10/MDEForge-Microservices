package org.mdeforge.projectservice.model;

import org.springframework.stereotype.Component;
import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.mdeforge.servicemodel.project.api.events.ProjectDomainEvent;

@Component
public class ProjectDomainEventPublisher extends AbstractAggregateDomainEventPublisher<Project,ProjectDomainEvent>{

	public ProjectDomainEventPublisher(DomainEventPublisher eventPublisher) {
		super(eventPublisher, Project.class, Project::getId);
    }
}
