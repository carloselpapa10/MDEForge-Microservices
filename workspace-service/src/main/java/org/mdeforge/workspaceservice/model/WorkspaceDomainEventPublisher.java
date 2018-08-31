package org.mdeforge.workspaceservice.model;

import org.springframework.stereotype.Component;
import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.mdeforge.servicemodel.workspace.api.events.WorkspaceDomainEvent;

@Component
public class WorkspaceDomainEventPublisher extends AbstractAggregateDomainEventPublisher<Workspace,WorkspaceDomainEvent>{

	public WorkspaceDomainEventPublisher(DomainEventPublisher eventPublisher) {
		super(eventPublisher, Workspace.class, Workspace::getId);
    }
}
