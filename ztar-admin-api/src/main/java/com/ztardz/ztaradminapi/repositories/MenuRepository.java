package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.MenuEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<MenuEntity,Integer> {
}
