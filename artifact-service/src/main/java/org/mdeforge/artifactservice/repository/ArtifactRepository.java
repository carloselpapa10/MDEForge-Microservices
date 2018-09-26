package org.mdeforge.artifactservice.repository;

import org.mdeforge.artifactservice.model.Artifact;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ArtifactRepository extends MongoRepository<Artifact,String>{

    Artifact findByName(String name);
}
