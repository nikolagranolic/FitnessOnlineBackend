package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.CommentEntity;

public interface CommentEntityRepository extends JpaRepository<CommentEntity, Integer> {
}
