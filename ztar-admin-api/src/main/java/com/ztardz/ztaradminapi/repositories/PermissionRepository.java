package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<PermissionEntity,Integer> {
    PermissionEntity findByName(String name);
}
