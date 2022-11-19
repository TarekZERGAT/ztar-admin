package com.ztardz.ztaradminapi.services.impl;

import com.ztardz.ztaradminapi.models.MenuEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import com.ztardz.ztaradminapi.repositories.MenuRepository;
import com.ztardz.ztaradminapi.services.MenuService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class MenuServiceImpl implements MenuService {

    private MenuRepository menuRepository;

    @Override
    public List<MenuEntity> browseAllMenus() {
        return menuRepository.findAll();
    }

    @Override
    public MenuEntity readMenuByName(String name) {
        return menuRepository.findByName(name);
    }

    @Override
    public MenuEntity editMenu(MenuEntity menu) {
        return null;
    }

    @Override
    public MenuEntity addNewMenu(MenuEntity menu) {
        return menuRepository.save(menu);
    }

    @Override
    public void deleteMenu(MenuEntity menu) {

    }
}
