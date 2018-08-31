package org.mdeforge.artifactservice.model;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends MongoRepository<Artifact,String>{

}
