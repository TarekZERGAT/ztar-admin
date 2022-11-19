package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.MenuItemEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface MenuItemService {
    List<MenuItemEntity> browseAllMenuItems();
    MenuItemEntity readMenuItemByTitle(String title);
    MenuItemEntity editMenuItem(MenuItemEntity menuItem);
    MenuItemEntity addNewMenuItem(MenuItemEntity menuItem);
    void deleteMenuItem(MenuItemEntity menuItem);
    void addParentToMenuItem(String parentName, String menuItemName);
    void addPermissionToMenuItem(String permissionName, String menuItemName);
}
