package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface PermissionService {
    List<PermissionEntity> browseAllPermissions(UserEntity createdBy);
    PermissionEntity readPermissionByName(String name, UserEntity createdBy);
    PermissionEntity editPermission(PermissionEntity permissionToEdit, UserEntity createdBy);
    PermissionEntity addNewPermission(PermissionEntity permissionToAdd, UserEntity createdBy);
    void deletePermission(PermissionEntity permissionToDelete, UserEntity createdBy, String motif);
}
