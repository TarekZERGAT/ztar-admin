package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.CollectionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CollectionRepository extends JpaRepository<CollectionEntity,Integer> {
    CollectionEntity findByName(String name);
}
