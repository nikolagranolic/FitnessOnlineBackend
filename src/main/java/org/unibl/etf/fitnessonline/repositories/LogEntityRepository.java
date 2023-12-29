package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.LogEntity;

public interface LogEntityRepository extends JpaRepository<LogEntity, Integer> {
}
