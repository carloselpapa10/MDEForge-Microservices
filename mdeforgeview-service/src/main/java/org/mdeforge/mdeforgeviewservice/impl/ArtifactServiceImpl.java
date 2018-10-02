package org.mdeforge.mdeforgeviewservice.impl;

import org.mdeforge.servicemodel.common.BusinessException;
import org.mdeforge.servicemodel.artifact.api.events.*;
import org.mdeforge.servicemodel.artifact.api.info.*;
import org.mdeforge.mdeforgeviewservice.dao.ArtifactService;
import org.mdeforge.mdeforgeviewservice.model.*;
import org.mdeforge.mdeforgeviewservice.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;
import org.bson.types.ObjectId;

@Component
@Transactional
public abstract class ArtifactServiceImpl<T extends Artifact> implements ArtifactService<T>{

	private static final Logger log = LoggerFactory.getLogger(ArtifactServiceImpl.class);

    protected Class<T> persistentClass;

    @Autowired
	protected ArtifactRepository artifactRepository;

    @Autowired
    protected SimpleMongoDbFactory mongoDbFactory;

    @SuppressWarnings("unchecked")
    public ArtifactServiceImpl() {
        this.persistentClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    @Override
    public T create(T artifact) throws BusinessException {
        return artifactRepository.save(artifact);
    }

    @Override
    public boolean existRelation(String idTo, String idFrom) throws BusinessException {
        return false;
    }

    @Override
    public List<T> findMyArtifacts(User user) throws BusinessException {

        MongoOperations n = new MongoTemplate(mongoDbFactory);
        Criteria userCriteria = Criteria.where("author.$id").is(new ObjectId(user.getId()));
        Query query = new Query();

        if (persistentClass != Artifact.class) {
            Criteria c = Criteria.where("_class").is(persistentClass.getCanonicalName());
            query.addCriteria(c);
            query.addCriteria(userCriteria);
            return n.find(query, persistentClass);
        }else{
            query.addCriteria(userCriteria);
            return n.find(query, persistentClass);
        }
    }

    @Override
    public void createIndex(Artifact artifact) throws BusinessException {

    }
}
