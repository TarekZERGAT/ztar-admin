package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.services.CollectionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class CollectionServiceImpl implements CollectionService {

    private CollectionRepository collectionRepository;

    @Override
    public List<CollectionEntity> browseAllCollections() {
        return collectionRepository.findAll();
    }

    @Override
    public CollectionEntity readCollectionByName(String name) {
        return collectionRepository.findByName(name);
    }

    @Override
    public CollectionEntity editCollection(CollectionEntity collection) {
        return null;
    }

    @Override
    public CollectionEntity addNewCollection(CollectionEntity collection) {
        return collectionRepository.save(collection);
    }

    @Override
    public void deleteCollection(CollectionEntity user) {

    }
}
