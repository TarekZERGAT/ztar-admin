package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.repositories.MenuItemRepository;
import com.ztardz.ztaradminapi.repositories.PermissionRepository;
import com.ztardz.ztaradminapi.services.MenuItemService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MenuItemServiceImpl implements MenuItemService {

    private MenuItemRepository menuItemRepository;

    private PermissionRepository permissionRepository;

    private ActivityRepository activityRepository;

    private CollectionRepository collectionRepository;

    private CollectionEntity collection;

    public MenuItemServiceImpl(MenuItemRepository menuItemRepository, PermissionRepository permissionRepository, ActivityRepository activityRepository, CollectionRepository collectionRepository) {
        this.menuItemRepository = menuItemRepository;
        this.permissionRepository = permissionRepository;
        this.activityRepository = activityRepository;
        this.collectionRepository = collectionRepository;
        this.collection = collectionRepository.findByName("menu_items");
    }

    @Override
    public List<MenuItemEntity> browseAllMenuItems(UserEntity createdBy) {
        List<MenuItemEntity> menuItems = menuItemRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menuItems;
    }

    @Override
    public MenuItemEntity readMenuItemByTitle(String title, UserEntity createdBy) {
        MenuItemEntity menuItem = menuItemRepository.findByTitle(title);
        ActivityEntity activity = new ActivityEntity("read", collection, menuItem.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menuItem;
    }

    @Override
    public MenuItemEntity editMenuItem(MenuItemEntity menuItemToEdit, UserEntity createdBy) {
        menuItemToEdit.setUpdatedAt(new Date());
        menuItemToEdit.setUpdatedBy(createdBy);
        MenuItemEntity menuItem = menuItemRepository.save(menuItemToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, menuItem.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menuItem;
    }

    @Override
    public MenuItemEntity addNewMenuItem(MenuItemEntity menuItemToAdd, UserEntity createdBy) {
        menuItemToAdd.setCreatedBy(createdBy);
        MenuItemEntity menuItem = menuItemRepository.save(menuItemToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, menuItem.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menuItem;
    }

    @Override
    public void deleteMenuItem(MenuItemEntity menuItemToDelete, UserEntity createdBy, String motif) {
        menuItemToDelete.setDeletedAt(new Date());
        menuItemToDelete.setDeletedBy(createdBy);
        menuItemToDelete.setDeletedFor(motif);
        MenuItemEntity menuItem = menuItemRepository.save(menuItemToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, menuItem.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
