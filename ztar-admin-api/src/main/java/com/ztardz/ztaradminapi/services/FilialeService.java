package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.models.FilialeEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface FilialeService {
    List<FilialeEntity> browseAllFiliales(UserEntity createdBy);
    FilialeEntity readFilialeByCode(String code,UserEntity createdBy);
    FilialeEntity editFiliale(FilialeEntity filialeToEdit,UserEntity createdBy);
    FilialeEntity addNewFiliale(FilialeEntity filialeToAdd,UserEntity createdBy);
    void deleteFiliale(FilialeEntity filialeToDelete,UserEntity createdBy, String motif);
}
