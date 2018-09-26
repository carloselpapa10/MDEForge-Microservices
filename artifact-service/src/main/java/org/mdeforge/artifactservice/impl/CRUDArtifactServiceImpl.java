package org.mdeforge.artifactservice.impl;

import org.mdeforge.artifactservice.dao.CRUDArtifactService;
import org.mdeforge.artifactservice.dao.DuplicateNameException;
import org.mdeforge.artifactservice.model.Artifact;
import org.mdeforge.artifactservice.model.Relation;
import org.mdeforge.artifactservice.repository.ArtifactRepository;
import org.mdeforge.artifactservice.repository.RelationRepository;
import org.mdeforge.servicemodel.common.BusinessException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class CRUDArtifactServiceImpl<T extends Artifact> implements CRUDArtifactService<T> {

    @Autowired
    protected ArtifactRepository artifactRepository;

    @Autowired
    protected RelationRepository relationRepository;

    @Value("${files.path}")
    public String files_path;

    @Override
    public boolean existRelation(String idTo, String idFrom) throws BusinessException {

        List<Relation> relations = relationRepository.findByFromArtifactIdOrToArtifactId(idFrom, idTo);
        return (relations.size() == 0) ? false : true;
    }

    @Override
    public T create(T artifact) throws BusinessException {

        if(artifactRepository.findByName(artifact.getName()) != null){
            throw new DuplicateNameException("Duplicate", "Duplicate artifact name");
        }

        if(artifact.getId() != null){throw new BusinessException();}

        /*file handler
        if(artifact.getFile() != null){

            try{
                artifact.getFile().transferTo(new File(files_path));
                artifact.setFileUrl(artifact.getFile().getName());
            }catch (IOException e){

            }

        }
        file handler*/

        artifact.setGenerated(false);
        artifact.setCreated(new Date());
        artifact.setModified(new Date());

        List<Relation> relationTemp = artifact.getRelations();
        artifact.setRelations(new ArrayList<Relation>());

        for(Relation rel : relationTemp){
            Artifact toArtifact = artifactRepository.findOne(rel.getToArtifact().getId());

            if(!existRelation(toArtifact.getId(), artifact.getId())){
                rel.setFromArtifact(artifact);
                artifact.getRelations().add(rel);

                relationRepository.save(rel);

                if(toArtifact.getRelations() == null){
                    toArtifact.setRelations(new ArrayList<>());
                }

                toArtifact.getRelations().add(rel);
                //artifactRepository.save(toArtifact);
            }
        }

        artifact.setRelations(relationTemp);
        createIndex(artifact);

        return artifact;
    }
}
