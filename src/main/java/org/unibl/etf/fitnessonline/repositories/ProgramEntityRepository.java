package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;

import java.util.List;

public interface ProgramEntityRepository extends JpaRepository<ProgramEntity, Integer> {
    List<ProgramEntity> getAllByUser_Id(Integer id);
}
