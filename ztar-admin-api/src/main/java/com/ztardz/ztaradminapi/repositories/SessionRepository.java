package com.ztardz.ztaradminapi.repositories;

import com.ztardz.ztaradminapi.models.SessionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SessionRepository extends JpaRepository<SessionEntity,Integer> {
}
