package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;

public interface ProgramEntityRepository extends JpaRepository<ProgramEntity, Integer> {
}
