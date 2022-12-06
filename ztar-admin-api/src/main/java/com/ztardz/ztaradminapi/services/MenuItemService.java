package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.MenuItemEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface MenuItemService {
    List<MenuItemEntity> browseAllMenuItems(UserEntity createdBy);
    MenuItemEntity readMenuItemByTitle(String title, UserEntity createdBy);
    MenuItemEntity editMenuItem(MenuItemEntity menuItemToEdit, UserEntity createdBy);
    MenuItemEntity addNewMenuItem(MenuItemEntity menuItemToAdd, UserEntity createdBy);
    void deleteMenuItem(MenuItemEntity menuItemToDelete, UserEntity createdBy, String motif);
}
