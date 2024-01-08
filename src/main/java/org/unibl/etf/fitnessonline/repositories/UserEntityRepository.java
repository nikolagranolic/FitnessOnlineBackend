package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;
import org.unibl.etf.fitnessonline.models.entities.UserEntity;

import java.util.List;
import java.util.Optional;

public interface UserEntityRepository extends JpaRepository<UserEntity, Integer> {
    Optional<UserEntity> findByUsername(String username);
    Optional<UserEntity> findByEmail(String email);

    @Query("SELECT DISTINCT p FROM ProgramEntity p " +
            "JOIN p.programParticipations pp " +
            "WHERE pp.user.id = :userId")
    List<ProgramEntity> findProgramsByUserId(@Param("userId") Integer userId);

    @Query("SELECT u FROM UserEntity u WHERE u.id <> :userId")
    List<UserEntity> findAllExceptUserId(@Param("userId") Integer userId);
}
