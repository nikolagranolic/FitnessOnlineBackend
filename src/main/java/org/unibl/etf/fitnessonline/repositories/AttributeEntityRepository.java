package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.AttributeEntity;

import java.util.List;

public interface AttributeEntityRepository extends JpaRepository<AttributeEntity, Integer> {
    List<AttributeEntity> getAllByCategory_Id(Integer id);
}
