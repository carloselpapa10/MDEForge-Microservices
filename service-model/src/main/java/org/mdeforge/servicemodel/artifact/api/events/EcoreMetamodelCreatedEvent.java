package org.mdeforge.servicemodel.artifact.api.events;

import org.mdeforge.servicemodel.artifact.api.info.EcoreMetamodelInfo;

public class EcoreMetamodelCreatedEvent implements EcoreMetamodelDomainEvent{

    private EcoreMetamodelInfo ecoreMetamodelInfo;

    public EcoreMetamodelCreatedEvent() {
    }

    public EcoreMetamodelCreatedEvent(EcoreMetamodelInfo ecoreMetamodelInfo) {
        this.ecoreMetamodelInfo = ecoreMetamodelInfo;
    }

    public EcoreMetamodelInfo getEcoreMetamodelInfo() {
        return ecoreMetamodelInfo;
    }

    public void setEcoreMetamodelInfo(EcoreMetamodelInfo ecoreMetamodelInfo) {
        this.ecoreMetamodelInfo = ecoreMetamodelInfo;
    }
}
