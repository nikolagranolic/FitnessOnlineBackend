package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.AdvisorEntity;

public interface AdvisorEntityRepository extends JpaRepository<AdvisorEntity, Integer> {
}
