package com.ztardz.ztaradminapi.services;

import com.ztardz.ztaradminapi.models.MenuEntity;
import com.ztardz.ztaradminapi.models.UserEntity;

import java.util.List;

public interface MenuService {
    List<MenuEntity> browseAllMenus();
    MenuEntity readMenuByName(String name);
    MenuEntity editMenu(MenuEntity menu);
    MenuEntity addNewMenu(MenuEntity menu);
    void deleteMenu(MenuEntity menu);
}
