package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface PermissionService {
    List<PermissionEntity> browseAllPermissions();
    PermissionEntity readPermissionByName(String name);
    PermissionEntity editPermission(PermissionEntity permission);
    PermissionEntity addNewPermission(PermissionEntity permission);
    void deletePermission(PermissionEntity permission);
}
