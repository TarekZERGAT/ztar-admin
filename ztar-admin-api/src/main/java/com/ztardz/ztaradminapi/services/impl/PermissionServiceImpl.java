package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.repositories.PermissionRepository;
import com.ztardz.ztaradminapi.services.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class PermissionServiceImpl implements PermissionService {

    private PermissionRepository permissionRepository;

    private ActivityRepository activityRepository;

    private CollectionRepository collectionRepository;

    private CollectionEntity collection;

    public PermissionServiceImpl(PermissionRepository permissionRepository, ActivityRepository activityRepository, CollectionRepository collectionRepository) {
        this.permissionRepository = permissionRepository;
        this.activityRepository = activityRepository;
        this.collectionRepository = collectionRepository;
        this.collection = collectionRepository.findByName("permissions");
    }

    @Override
    public List<PermissionEntity> browseAllPermissions(UserEntity createdBy) {
        List<PermissionEntity> permissions = permissionRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return permissions;
    }

    @Override
    public PermissionEntity readPermissionByName(String name, UserEntity createdBy) {
        PermissionEntity permission = permissionRepository.findByName(name);
        ActivityEntity activity = new ActivityEntity("read", collection, permission.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return permission;
    }

    @Override
    public PermissionEntity editPermission(PermissionEntity permissionToEdit, UserEntity createdBy) {
        permissionToEdit.setUpdatedAt(new Date());
        permissionToEdit.setUpdatedBy(createdBy);
        PermissionEntity permission = permissionRepository.save(permissionToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, permission.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return permission;
    }

    @Override
    public PermissionEntity addNewPermission(PermissionEntity permissionToAdd, UserEntity createdBy) {
        permissionToAdd.setCreatedBy(createdBy);
        PermissionEntity permission = permissionRepository.save(permissionToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, permission.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return permission;
    }

    @Override
    public void deletePermission(PermissionEntity permissionToDelete, UserEntity createdBy, String motif) {
        permissionToDelete.setDeletedAt(new Date());
        permissionToDelete.setDeletedBy(createdBy);
        permissionToDelete.setDeletedFor(motif);
        PermissionEntity permission = permissionRepository.save(permissionToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, permission.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
