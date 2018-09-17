package org.mdeforge.mdeforgeviewservice.repository;

import org.mdeforge.mdeforgeviewservice.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepository extends MongoRepository<Project,String>{

    List<Project> findByOwner(User owner);
}			
