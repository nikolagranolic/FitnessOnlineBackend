package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.unibl.etf.fitnessonline.models.entities.ProgramEntity;

import java.util.List;

public interface ProgramEntityRepository extends JpaRepository<ProgramEntity, Integer>, JpaSpecificationExecutor<ProgramEntity> {
    List<ProgramEntity> getAllByUser_Id(Integer id);
    boolean existsByUser_IdAndId(Integer userId, Integer programId);
}
