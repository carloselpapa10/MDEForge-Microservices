package org.mdeforge.mdeforgeviewservice.repository;

import org.mdeforge.mdeforgeviewservice.model.*;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkspaceRepository extends MongoRepository<Workspace,String>{

    public List<Workspace> findByOwner(User user);
}			
