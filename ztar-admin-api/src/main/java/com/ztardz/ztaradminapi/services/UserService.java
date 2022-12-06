package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface UserService {
    List<UserEntity> browseAllUsers(UserEntity createdBy);
    UserEntity readUserByUsername(String username, UserEntity createdBy);
    UserEntity editUser(UserEntity userToEdit,UserEntity createdBy);
    UserEntity addNewUser(UserEntity userToAdd,UserEntity createdBy);
    void deleteUser(UserEntity userToDelete,UserEntity createdBy, String motif);
    void addRoleToUser(String roleName, String userName,UserEntity createdBy);
    void addPermissionToUser(String permissionName, String userName,UserEntity createdBy);
}
