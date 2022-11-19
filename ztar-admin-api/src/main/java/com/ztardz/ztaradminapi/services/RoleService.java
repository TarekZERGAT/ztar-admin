package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleEntity> browseAllRoles();
    RoleEntity readRoleByName(String name);
    RoleEntity editRole(RoleEntity role);
    RoleEntity addNewRole(RoleEntity role);
    void deleteRole(RoleEntity role);
    void addPermissionToRole(String permissionName, String roleName);
}
