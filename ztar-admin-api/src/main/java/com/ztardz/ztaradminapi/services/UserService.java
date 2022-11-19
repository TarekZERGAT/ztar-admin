package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> browseAllUsers();
    UserEntity readUserByUsername(String username);
    UserEntity editUser(UserEntity user);
    UserEntity addNewUser(UserEntity user);
    void deleteUser(UserEntity user);
    void addRoleToUser(String roleName, String userName);
    void addPermissionToUser(String permissionName, String userName);
}
