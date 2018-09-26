package org.mdeforge.artifactservice.repository;

import org.mdeforge.artifactservice.model.Metric;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MetricRepository extends MongoRepository<Metric, String> {

    Metric findByNameAndArtifactId(String name, String id);
    Metric findByName(String name);
}
