package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.CollectionEntity;
import com.ztardz.ztaradminapi.models.UniteEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface UniteService {
    List<UniteEntity> browseAllUnites(UserEntity createdBy);
    UniteEntity readUniteByCode(String code,UserEntity createdBy);
    UniteEntity editUnite(UniteEntity uniteToEdit,UserEntity createdBy);
    UniteEntity addNewUnite(UniteEntity uniteToAdd,UserEntity createdBy);
    void deleteUnite(UniteEntity uniteToDelete,UserEntity createdBy, String motif);
}
