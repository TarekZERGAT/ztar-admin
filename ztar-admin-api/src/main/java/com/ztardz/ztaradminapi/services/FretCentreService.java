package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.models.FretCentreEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface FretCentreService {
    List<FretCentreEntity> browseAllFretCentres(UserEntity createdBy);
    FretCentreEntity readFretCentreByCode(String code,UserEntity createdBy);
    FretCentreEntity editFretCentre(FretCentreEntity fretCentreToEdit,UserEntity createdBy);
    FretCentreEntity addNewFretCentre(FretCentreEntity fretCentreToAdd,UserEntity createdBy);
    void deleteFretCentre(FretCentreEntity fretCentreToDelete,UserEntity createdBy, String motif);
}
