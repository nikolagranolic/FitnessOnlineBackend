package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.ActivityEntity;

public interface ActivityEntityRepository extends JpaRepository<ActivityEntity, Integer> {
}
