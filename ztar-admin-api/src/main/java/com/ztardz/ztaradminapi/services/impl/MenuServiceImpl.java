package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.*;
import com.ztardz.ztaradminapi.repositories.ActivityRepository;
import com.ztardz.ztaradminapi.repositories.CollectionRepository;
import com.ztardz.ztaradminapi.repositories.MenuRepository;
import com.ztardz.ztaradminapi.services.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    private ActivityRepository activityRepository;

    private CollectionRepository collectionRepository;

    private CollectionEntity collection;

    public MenuServiceImpl(MenuRepository menuRepository, ActivityRepository activityRepository, CollectionRepository collectionRepository) {
        this.menuRepository = menuRepository;
        this.activityRepository = activityRepository;
        this.collectionRepository = collectionRepository;
        this.collection = collectionRepository.findByName("menus");
    }

    @Override
    public List<MenuEntity> browseAllMenus(UserEntity createdBy) {
        List<MenuEntity> menus = menuRepository.findAll();
        ActivityEntity activity = new ActivityEntity("browse",collection,null,createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menus;
    }

    @Override
    public MenuEntity readMenuByName(String name, UserEntity createdBy) {
        MenuEntity menu = menuRepository.findByName(name);
        ActivityEntity activity = new ActivityEntity("read", collection, menu.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menu;
    }

    @Override
    public MenuEntity editMenu(MenuEntity menuToEdit, UserEntity createdBy) {
        menuToEdit.setUpdatedAt(new Date());
        menuToEdit.setUpdatedBy(createdBy);
        MenuEntity menu = menuRepository.save(menuToEdit);
        ActivityEntity activity = new ActivityEntity("edit", collection, menu.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menu;
    }

    @Override
    public MenuEntity addNewMenu(MenuEntity menuToAdd, UserEntity createdBy) {
        menuToAdd.setCreatedBy(createdBy);
        MenuEntity menu = menuRepository.save(menuToAdd);
        ActivityEntity activity = new ActivityEntity("add", collection, menu.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
        return menu;
    }

    @Override
    public void deleteMenu(MenuEntity menuToDelete, UserEntity createdBy, String motif) {
        menuToDelete.setDeletedAt(new Date());
        menuToDelete.setDeletedBy(createdBy);
        menuToDelete.setDeletedFor(motif);
        MenuEntity menu = menuRepository.save(menuToDelete);
        ActivityEntity activity = new ActivityEntity("delete", collection, menu.getId(), createdBy);
        ActivityEntity savedActivity = activityRepository.save(activity);
    }
}
