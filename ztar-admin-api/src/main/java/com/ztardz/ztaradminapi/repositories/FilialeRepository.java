package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.FilialeEntity;
import com.ztardz.ztaradminapi.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FilialeRepository extends JpaRepository<FilialeEntity,Integer> {
    FilialeEntity findByCode(String code);
    FilialeEntity findByName(String name);
}
