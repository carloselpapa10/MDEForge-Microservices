package org.mdeforge.mdeforgeviewservice.messaging;

import io.eventuate.tram.events.common.DomainEvent;
import io.eventuate.tram.events.subscriber.DomainEventEnvelope;
import io.eventuate.tram.events.subscriber.DomainEventHandlers;
import io.eventuate.tram.events.subscriber.DomainEventHandlersBuilder;
import org.mdeforge.mdeforgeviewservice.dao.ArtifactService;
import org.mdeforge.mdeforgeviewservice.dao.UserService;
import org.mdeforge.mdeforgeviewservice.model.EcoreMetamodel;
import org.mdeforge.mdeforgeviewservice.model.Property;
import org.mdeforge.mdeforgeviewservice.model.User;
import org.mdeforge.servicemodel.artifact.api.events.EcoreMetamodelCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

@Component
public class EcoreMetamodelHistoryEventHandlers {

    private static final Logger log = LoggerFactory.getLogger(EcoreMetamodelHistoryEventHandlers.class);

    @Autowired
    private UserService userService;

    @Autowired
    private ArtifactService artifactService;

    public DomainEventHandlers domainEventHandlers() {
        return DomainEventHandlersBuilder
                .forAggregateType("org.mdeforge.artifactservice.model.EcoreMetamodel")
                .onEvent(EcoreMetamodelCreatedEvent.class, this::handleEcoreMetamodelCreatedEvent)
                .build();
    }

    private void handleEcoreMetamodelCreatedEvent(DomainEventEnvelope<EcoreMetamodelCreatedEvent> dee) {
        log.info("handleEcoreMetamodelCreatedEvent() - EcoreMetamodelHistoryEventHandlers - ArtifactService");

        EcoreMetamodel ecoreMetamodel = new EcoreMetamodel();
        ecoreMetamodel.setId(dee.getAggregateId());
        ecoreMetamodel.setName(dee.getEvent().getEcoreMetamodelInfo().getName());
        ecoreMetamodel.setDescription(dee.getEvent().getEcoreMetamodelInfo().getDescription());
        ecoreMetamodel.setAuthor(userService.findUser(dee.getEvent().getEcoreMetamodelInfo().getAuthor()));
        ecoreMetamodel.setFileName(dee.getEvent().getEcoreMetamodelInfo().getFileName());
        ecoreMetamodel.setFileUrl(dee.getEvent().getEcoreMetamodelInfo().getFileUrl());
        ecoreMetamodel.setGenerated(dee.getEvent().getEcoreMetamodelInfo().isGenerated());
        ecoreMetamodel.setCreated(dee.getEvent().getEcoreMetamodelInfo().getCreated());
        ecoreMetamodel.setModified(dee.getEvent().getEcoreMetamodelInfo().getModified());

        List<Property> propertyList = new ArrayList<>();
        dee.getEvent().getEcoreMetamodelInfo().getPropertiesInfo().forEach(property -> {
            propertyList.add(new Property(property.getName(), property.getValue()));
        });

        ecoreMetamodel.setProperties(propertyList);

        List<User> userList = new ArrayList<>();
        dee.getEvent().getEcoreMetamodelInfo().getShareduserlist().forEach(shared ->{
            userList.add(userService.findUser(shared));
        });

        ecoreMetamodel.setSharedUserList(userList);

        artifactService.create(ecoreMetamodel);
    }

}
