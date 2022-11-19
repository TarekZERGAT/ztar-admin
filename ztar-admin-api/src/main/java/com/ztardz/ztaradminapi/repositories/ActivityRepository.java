package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.ActivityEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityEntity,Integer> {
}
