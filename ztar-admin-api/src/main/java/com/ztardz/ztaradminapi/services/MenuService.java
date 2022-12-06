package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.MenuEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface MenuService {
    List<MenuEntity> browseAllMenus(UserEntity createdBy);
    MenuEntity readMenuByName(String name, UserEntity createdBy);
    MenuEntity editMenu(MenuEntity menuToEdit, UserEntity createdBy);
    MenuEntity addNewMenu(MenuEntity menuToAdd, UserEntity createdBy);
    void deleteMenu(MenuEntity menuToDelete, UserEntity createdBy, String motif);
}
