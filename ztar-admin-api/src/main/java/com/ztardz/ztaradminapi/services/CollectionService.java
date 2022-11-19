package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface CollectionService {
    List<CollectionEntity> browseAllCollections();
    CollectionEntity readCollectionByName(String name);
    CollectionEntity editCollection(CollectionEntity collection);
    CollectionEntity addNewCollection(CollectionEntity collection);
    void deleteCollection(CollectionEntity user);
}
