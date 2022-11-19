package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.MenuEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuEntity,Integer> {
    MenuEntity findByName(String name);
}
