package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.repositories.PermissionRepository;
import com.ztardz.ztaradminapi.repositories.RoleRepository;
import com.ztardz.ztaradminapi.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    private PermissionRepository permissionRepository;

    private ActivityRepository activityRepository;

    private CollectionRepository collectionRepository;

    private CollectionEntity collection;

    public RoleServiceImpl(RoleRepository roleRepository, PermissionRepository permissionRepository, CollectionRepository collectionRepository, ActivityRepository activityRepository) {
        this.roleRepository = roleRepository;
        this.permissionRepository = permissionRepository;
        this.activityRepository = activityRepository;
        this.collectionRepository = collectionRepository;
        this.collection = collectionRepository.findByName("roles");
    }

    @Override
    public List<RoleEntity> browseAllRoles(UserEntity createdBy) {
        List<RoleEntity> roles = roleRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return roles;
    }

    @Override
    public RoleEntity readRoleByName(String name, UserEntity createdBy) {
        RoleEntity role = roleRepository.findByName(name);
        ActivityEntity activity = new ActivityEntity("read", collection, role.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return role;
    }

    @Override
    public RoleEntity editRole(RoleEntity roleToEdit, UserEntity createdBy) {
        roleToEdit.setUpdatedAt(new Date());
        roleToEdit.setUpdatedBy(createdBy);
        RoleEntity role = roleRepository.save(roleToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, role.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return role;
    }

    @Override
    public RoleEntity addNewRole(RoleEntity roleToAdd, UserEntity createdBy) {
        roleToAdd.setCreatedBy(createdBy);
        RoleEntity role = roleRepository.save(roleToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, role.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return role;
    }

    @Override
    public void deleteRole(RoleEntity roleToDelete, UserEntity createdBy, String motif) {
        roleToDelete.setDeletedAt(new Date());
        roleToDelete.setDeletedBy(createdBy);
        roleToDelete.setDeletedFor(motif);
        RoleEntity role = roleRepository.save(roleToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, role.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }

    @Override
    public void addPermissionToRole(String permissionName, String roleName, UserEntity createdBy) {
        PermissionEntity permission = permissionRepository.findByName(permissionName);
        RoleEntity role = roleRepository.findByName(roleName);
        role.addPermission(permission);
        //role.getPermissions().add(permission);
        ActivityEntity activity = new ActivityEntity("action01", collection, role.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
