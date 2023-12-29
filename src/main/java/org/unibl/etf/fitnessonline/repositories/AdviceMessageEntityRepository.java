package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.AdviceMessageEntity;

public interface AdviceMessageEntityRepository extends JpaRepository<AdviceMessageEntity, Integer> {
}
