package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.ActivityEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ActivityRepository extends JpaRepository<ActivityEntity,Integer> {
}
