package org.mdeforge.artifactservice.model;

import org.springframework.stereotype.Component;
import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.mdeforge.servicemodel.artifact.api.events.ArtifactDomainEvent;

@Component
public class ArtifactDomainEventPublisher extends AbstractAggregateDomainEventPublisher<Artifact,ArtifactDomainEvent>{

	public ArtifactDomainEventPublisher(DomainEventPublisher eventPublisher) {
		super(eventPublisher, Artifact.class, Artifact::getId);
    }
}
