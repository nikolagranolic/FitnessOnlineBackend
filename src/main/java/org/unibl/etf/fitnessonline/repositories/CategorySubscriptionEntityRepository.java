package org.unibl.etf.fitnessonline.repositories;

import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.unibl.etf.fitnessonline.models.entities.CategorySubscriptionEntity;

public interface CategorySubscriptionEntityRepository extends JpaRepository<CategorySubscriptionEntity, Integer> {
    @Transactional
    void deleteByUser_IdAndCategory_Id(Integer userId, Integer categoryId);
    boolean existsByUser_IdAndCategory_Id(Integer userId, Integer categoryId);
}
