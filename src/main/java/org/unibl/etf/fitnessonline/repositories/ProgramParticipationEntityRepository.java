package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.ProgramParticipationEntity;

import java.util.Optional;

public interface ProgramParticipationEntityRepository extends JpaRepository<ProgramParticipationEntity, Integer> {
    Optional<ProgramParticipationEntity> findByUser_IdAndProgram_Id(Integer userId, Integer programId);
}
