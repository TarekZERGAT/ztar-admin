package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.UniteEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UniteRepository extends JpaRepository<UniteEntity,Integer> {
}
