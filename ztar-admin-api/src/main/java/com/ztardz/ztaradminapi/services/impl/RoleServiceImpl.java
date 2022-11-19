package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.models.RoleEntity;
import com.ztardz.ztaradminapi.repositories.PermissionRepository;
import com.ztardz.ztaradminapi.repositories.RoleRepository;
import com.ztardz.ztaradminapi.services.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class RoleServiceImpl implements RoleService {

    private RoleRepository roleRepository;

    private PermissionRepository permissionRepository;

    @Override
    public List<RoleEntity> browseAllRoles() {
        return roleRepository.findAll();
    }

    @Override
    public RoleEntity readRoleByName(String name) {
        return roleRepository.findByName(name);
    }

    @Override
    public RoleEntity editRole(RoleEntity role) {
        return null;
    }

    @Override
    public RoleEntity addNewRole(RoleEntity role) {
        return roleRepository.save(role);
    }

    @Override
    public void deleteRole(RoleEntity role) {

    }

    @Override
    public void addPermissionToRole(String permissionName, String roleName) {
        PermissionEntity permission = permissionRepository.findByName(permissionName);
        RoleEntity role = roleRepository.findByName(roleName);
        role.addPermission(permission);
        //role.getPermissions().add(permission);
    }
}
