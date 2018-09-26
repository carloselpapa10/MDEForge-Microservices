package org.mdeforge.artifactservice.dao;

import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.artifactservice.model.Metric;
import org.mdeforge.servicemodel.common.BusinessException;

import java.util.List;

public interface MetricProvider {

    List<Metric> calculateMetrics(Artifact artifact) throws BusinessException;
}
