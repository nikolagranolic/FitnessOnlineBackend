package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
}
