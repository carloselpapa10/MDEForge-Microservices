package org.mdeforge.artifactservice.repository;

import org.mdeforge.artifactservice.model.Relation;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RelationRepository extends MongoRepository<Relation, String> {

    List<Relation> findByToArtifactId(String id);
    List<Relation> findByFromArtifactId(String id);
    List<Relation> findByFromArtifactIdOrToArtifactId(String idFrom, String idTo);
}
