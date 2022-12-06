package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface CollectionService {
    List<CollectionEntity> browseAllCollections(UserEntity createdBy);
    CollectionEntity readCollectionByName(String name,UserEntity createdBy);
    CollectionEntity editCollection(CollectionEntity collectionToEdit,UserEntity createdBy);
    CollectionEntity addNewCollection(CollectionEntity collectionToAdd,UserEntity createdBy);
    void deleteCollection(CollectionEntity collectionToDelete,UserEntity createdBy, String motif);
}
