package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.ActivityEntity;
import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.services.CollectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CollectionServiceImpl implements CollectionService {

    private CollectionRepository collectionRepository;

    private ActivityRepository activityRepository;

    private CollectionEntity collection;

    public CollectionServiceImpl(CollectionRepository collectionRepository, ActivityRepository activityRepository) {
        this.collectionRepository = collectionRepository;
        this.activityRepository = activityRepository;
        this.collection = collectionRepository.findByName("collections");
    }

    @Override
    public List<CollectionEntity> browseAllCollections(UserEntity createdBy) {
        List<CollectionEntity> collections = collectionRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return collections;
    }

    @Override
    public CollectionEntity readCollectionByName(String name,UserEntity createdBy) {
        CollectionEntity col = collectionRepository.findByName(name);
        ActivityEntity activity = new ActivityEntity("read", collection, col.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return col;
    }

    @Override
    public CollectionEntity editCollection(CollectionEntity collectionToEdit,UserEntity createdBy) {
        collectionToEdit.setUpdatedAt(new Date());
        collectionToEdit.setUpdatedBy(createdBy);
        CollectionEntity col = collectionRepository.save(collectionToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, col.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return col;
    }

    @Override
    public CollectionEntity addNewCollection(CollectionEntity collectionToAdd,UserEntity createdBy) {
        collectionToAdd.setCreatedBy(createdBy);
        CollectionEntity col = collectionRepository.save(collectionToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, col.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return col;
    }

    @Override
    public void deleteCollection(CollectionEntity collectionToDelete,UserEntity createdBy, String motif) {
        collectionToDelete.setDeletedAt(new Date());
        collectionToDelete.setDeletedBy(createdBy);
        collectionToDelete.setDeletedFor(motif);
        CollectionEntity col = collectionRepository.save(collectionToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, collectionToDelete.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
