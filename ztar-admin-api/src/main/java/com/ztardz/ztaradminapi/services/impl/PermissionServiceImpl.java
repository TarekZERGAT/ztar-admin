package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.repositories.PermissionRepository;
import com.ztardz.ztaradminapi.services.PermissionService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class PermissionServiceImpl implements PermissionService {

    private PermissionRepository permissionRepository;

    @Override
    public List<PermissionEntity> browseAllPermissions() {
        return permissionRepository.findAll();
    }

    @Override
    public PermissionEntity readPermissionByName(String name) {
        return permissionRepository.findByName(name);
    }

    @Override
    public PermissionEntity editPermission(PermissionEntity permission) {
        return null;
    }

    @Override
    public PermissionEntity addNewPermission(PermissionEntity permission) {
        return permissionRepository.save(permission);
    }

    @Override
    public void deletePermission(PermissionEntity permission) {

    }
}
