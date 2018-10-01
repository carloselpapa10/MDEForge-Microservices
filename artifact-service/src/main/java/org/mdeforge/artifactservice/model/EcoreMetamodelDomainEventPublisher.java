package org.mdeforge.artifactservice.model;

import io.eventuate.tram.events.aggregates.AbstractAggregateDomainEventPublisher;
import io.eventuate.tram.events.publisher.DomainEventPublisher;
import org.mdeforge.servicemodel.artifact.api.events.EcoreMetamodelDomainEvent;
import org.springframework.stereotype.Component;

@Component
public class EcoreMetamodelDomainEventPublisher extends AbstractAggregateDomainEventPublisher<EcoreMetamodel, EcoreMetamodelDomainEvent> {

    public EcoreMetamodelDomainEventPublisher(DomainEventPublisher eventPublisher) {
        super(eventPublisher, EcoreMetamodel.class, EcoreMetamodel::getId);
    }
}
