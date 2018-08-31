package org.mdeforge.mdeforgeviewservice.repository;

import org.mdeforge.mdeforgeviewservice.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArtifactRepository extends MongoRepository<Artifact,String>{

}			
