package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.repositories.FilialeRepository;
import com.ztardz.ztaradminapi.repositories.UniteRepository;
import com.ztardz.ztaradminapi.services.UniteService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UniteServiceImpl implements UniteService {

    private UniteRepository uniteRepository;

    private CollectionRepository collectionRepository;

    private ActivityRepository activityRepository;

    private CollectionEntity collection;

    public UniteServiceImpl(UniteRepository uniteRepository, CollectionRepository collectionRepository, ActivityRepository activityRepository) {
        this.uniteRepository = uniteRepository;
        this.collectionRepository = collectionRepository;
        this.activityRepository = activityRepository;
        this.collection = collectionRepository.findByName("unites");
    }

    @Override
    public List<UniteEntity> browseAllUnites(UserEntity createdBy) {
        List<UniteEntity> unites = uniteRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return unites;
    }

    @Override
    public UniteEntity readUniteByCode(String code, UserEntity createdBy) {
        UniteEntity unite = uniteRepository.findByCode(code);
        ActivityEntity activity = new ActivityEntity("read", collection, unite.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return unite;
    }

    @Override
    public UniteEntity editUnite(UniteEntity uniteToEdit, UserEntity createdBy) {
        uniteToEdit.setUpdatedAt(new Date());
        uniteToEdit.setUpdatedBy(createdBy);
        UniteEntity unite = uniteRepository.save(uniteToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, unite.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return unite;
    }

    @Override
    public UniteEntity addNewUnite(UniteEntity uniteToAdd, UserEntity createdBy) {
        uniteToAdd.setCreatedBy(createdBy);
        UniteEntity unite = uniteRepository.save(uniteToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, unite.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return unite;
    }

    @Override
    public void deleteUnite(UniteEntity uniteToDelete, UserEntity createdBy, String motif) {
        uniteToDelete.setDeletedAt(new Date());
        uniteToDelete.setDeletedBy(createdBy);
        uniteToDelete.setDeletedFor(motif);
        UniteEntity unite = uniteRepository.save(uniteToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, unite.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
