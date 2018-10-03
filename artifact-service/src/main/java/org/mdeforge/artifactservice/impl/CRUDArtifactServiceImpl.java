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
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class CRUDArtifactServiceImpl<T extends Artifact> implements CRUDArtifactService<T> {

    private static final Logger log = LoggerFactory.getLogger(CRUDArtifactServiceImpl.class);

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
    public T create(T artifact, MultipartFile file) throws BusinessException {

        log.info("create(T artifact, MultipartFile file) - CRUDArtifactServiceImpl - ArtifactService");

        if(artifactRepository.findByName(artifact.getName()) != null){
            throw new DuplicateNameException("Duplicate", "Duplicate artifact name");
        }

        if(artifact.getId() != null){throw new BusinessException();}

        UUID uuid = UUID.randomUUID();
        try{
            log.info(files_path);
            file.transferTo(new File(files_path+"/"+uuid.toString()+"_"+file.getOriginalFilename()));
            artifact.setFileUrl(uuid.toString()+"_"+file.getOriginalFilename());
        }catch (IOException e){
            log.error(e.getMessage());
            throw new BusinessException(e.getMessage()+" "+e.getCause());
        }

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
