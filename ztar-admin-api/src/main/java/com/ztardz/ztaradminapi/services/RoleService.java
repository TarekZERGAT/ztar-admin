package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.RoleEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> browseAllRoles(UserEntity createdBy);
    RoleEntity readRoleByName(String name, UserEntity createdBy);
    RoleEntity editRole(RoleEntity roleToEdit, UserEntity createdBy);
    RoleEntity addNewRole(RoleEntity roleToAdd, UserEntity createdBy);
    void deleteRole(RoleEntity roleToDelete, UserEntity createdBy, String motif);
    void addPermissionToRole(String permissionName, String roleName, UserEntity createdBy);
}
