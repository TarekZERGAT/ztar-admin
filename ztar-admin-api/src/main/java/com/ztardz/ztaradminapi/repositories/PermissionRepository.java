package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.PermissionEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PermissionRepository extends JpaRepository<PermissionEntity,Integer> {
}
