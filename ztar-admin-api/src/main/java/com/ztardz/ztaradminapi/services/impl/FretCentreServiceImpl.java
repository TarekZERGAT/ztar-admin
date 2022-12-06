package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.repositories.FretCentreRepository;
import com.ztardz.ztaradminapi.repositories.UniteRepository;
import com.ztardz.ztaradminapi.services.FretCentreService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FretCentreServiceImpl implements FretCentreService {

    private FretCentreRepository fretCentreRepository;

    private CollectionRepository collectionRepository;

    private ActivityRepository activityRepository;

    private CollectionEntity collection;

    public FretCentreServiceImpl(FretCentreRepository fretCentreRepository, CollectionRepository collectionRepository, ActivityRepository activityRepository) {
        this.fretCentreRepository = fretCentreRepository;
        this.collectionRepository = collectionRepository;
        this.activityRepository = activityRepository;
        this.collection = collectionRepository.findByName("fret_centres");
    }

    @Override
    public List<FretCentreEntity> browseAllFretCentres(UserEntity createdBy) {
        List<FretCentreEntity> fretCentres = fretCentreRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return fretCentres;
    }

    @Override
    public FretCentreEntity readFretCentreByCode(String code, UserEntity createdBy) {
        FretCentreEntity fretCentre = fretCentreRepository.findByCode(code);
        ActivityEntity activity = new ActivityEntity("read", collection, fretCentre.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return fretCentre;
    }

    @Override
    public FretCentreEntity editFretCentre(FretCentreEntity fretCentreToEdit, UserEntity createdBy) {
        fretCentreToEdit.setUpdatedAt(new Date());
        fretCentreToEdit.setUpdatedBy(createdBy);
        FretCentreEntity fretCentre = fretCentreRepository.save(fretCentreToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, fretCentre.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return fretCentre;
    }

    @Override
    public FretCentreEntity addNewFretCentre(FretCentreEntity fretCentreToAdd, UserEntity createdBy) {
        fretCentreToAdd.setCreatedBy(createdBy);
        FretCentreEntity fretCentre = fretCentreRepository.save(fretCentreToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, fretCentre.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return fretCentre;
    }

    @Override
    public void deleteFretCentre(FretCentreEntity fretCentreToDelete, UserEntity createdBy, String motif) {
        fretCentreToDelete.setDeletedAt(new Date());
        fretCentreToDelete.setDeletedBy(createdBy);
        fretCentreToDelete.setDeletedFor(motif);
        FretCentreEntity fretCentre = fretCentreRepository.save(fretCentreToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, fretCentre.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
