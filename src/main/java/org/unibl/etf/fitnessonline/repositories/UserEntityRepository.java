package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;

import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);
}
