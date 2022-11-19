package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.MenuItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuItemRepository extends JpaRepository<MenuItemEntity,Integer> {
    MenuItemEntity findByTitle(String title);
}
