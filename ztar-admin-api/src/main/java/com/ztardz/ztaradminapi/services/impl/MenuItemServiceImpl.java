package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.MenuItemEntity;
import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.repositories.MenuItemRepository;
import com.ztardz.ztaradminapi.repositories.PermissionRepository;
import com.ztardz.ztaradminapi.services.MenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;

    private PermissionRepository permissionRepository;

    @Override
    public List<MenuItemEntity> browseAllMenuItems() {
        return menuItemRepository.findAll();
    }

    @Override
    public MenuItemEntity readMenuItemByTitle(String title) {
        return menuItemRepository.findByTitle(title);
    }

    @Override
    public MenuItemEntity editMenuItem(MenuItemEntity menuItem) {
        return null;
    }

    @Override
    public MenuItemEntity addNewMenuItem(MenuItemEntity menuItem) {
        return menuItemRepository.save(menuItem);
    }

    @Override
    public void deleteMenuItem(MenuItemEntity menuItem) {

    }

    @Override
    public void addParentToMenuItem(String parentName, String menuItemName) {
        MenuItemEntity parent = menuItemRepository.findByTitle(parentName);
        MenuItemEntity menuItem = menuItemRepository.findByTitle(menuItemName);
        menuItem.setParent(parent);
    }

    @Override
    public void addPermissionToMenuItem(String permissionName, String menuItemName) {
        PermissionEntity permission = permissionRepository.findByName(permissionName);
        MenuItemEntity menuItem = menuItemRepository.findByTitle(menuItemName);
        menuItem.setPermission(permission);
    }
}
