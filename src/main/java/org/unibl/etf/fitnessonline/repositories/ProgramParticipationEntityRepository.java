package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.ProgramParticipationEntity;

public interface ProgramParticipationEntityRepository extends JpaRepository<ProgramParticipationEntity, Integer> {
}
