package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.MenuItemEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuItemRepository extends JpaRepository<MenuItemEntity,Integer> {
}
