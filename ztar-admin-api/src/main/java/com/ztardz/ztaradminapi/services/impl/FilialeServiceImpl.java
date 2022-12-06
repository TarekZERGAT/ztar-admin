package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.ActivityEntity;
import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.models.FilialeEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.repositories.FilialeRepository;
import com.ztardz.ztaradminapi.services.FilialeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class FilialeServiceImpl implements FilialeService {

    private FilialeRepository filialeRepository;

    private CollectionRepository collectionRepository;

    private ActivityRepository activityRepository;

    private CollectionEntity collection;

    public FilialeServiceImpl(FilialeRepository filialeRepository, CollectionRepository collectionRepository, ActivityRepository activityRepository) {
        this.filialeRepository = filialeRepository;
        this.collectionRepository = collectionRepository;
        this.activityRepository = activityRepository;
        this.collection = collectionRepository.findByName("filiales");
    }

    @Override
    public List<FilialeEntity> browseAllFiliales(UserEntity createdBy) {
        List<FilialeEntity> filailes = filialeRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return filailes;
    }

    @Override
    public FilialeEntity readFilialeByCode(String code, UserEntity createdBy) {
        FilialeEntity filiale = filialeRepository.findByCode(code);
        ActivityEntity activity = new ActivityEntity("read", collection, filiale.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return filiale;
    }

    @Override
    public FilialeEntity editFiliale(FilialeEntity filialeToEdit, UserEntity createdBy) {
        filialeToEdit.setUpdatedAt(new Date());
        filialeToEdit.setUpdatedBy(createdBy);
        FilialeEntity filiale = filialeRepository.save(filialeToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, filiale.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return filiale;
    }

    @Override
    public FilialeEntity addNewFiliale(FilialeEntity filialeToAdd, UserEntity createdBy) {
        filialeToAdd.setCreatedBy(createdBy);
        FilialeEntity filiale = filialeRepository.save(filialeToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, filiale.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return filiale;
    }

    @Override
    public void deleteFiliale(FilialeEntity filialeToDelete, UserEntity createdBy, String motif) {
        filialeToDelete.setDeletedAt(new Date());
        filialeToDelete.setDeletedBy(createdBy);
        filialeToDelete.setDeletedFor(motif);
        FilialeEntity filiale = filialeRepository.save(filialeToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, filiale.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
