package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.RoleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<RoleEntity,Integer> {
    RoleEntity findByName(String name);
}
