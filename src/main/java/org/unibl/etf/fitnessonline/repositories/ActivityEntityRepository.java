package org.unibl.etf.fitnessonline.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.unibl.etf.fitnessonline.models.entities.ActivityEntity;

import java.sql.Date;
import java.util.List;

public interface ActivityEntityRepository extends JpaRepository<ActivityEntity, Integer> {
    List<ActivityEntity> findByUserIdOrderByDateAsc(Integer userId);
    @Query("SELECT a FROM ActivityEntity a WHERE (:beginDate IS NULL OR a.date >= :beginDate) AND (:endDate IS NULL OR a.date <= :endDate) AND a.user.id = :userId ORDER BY a.date ASC")
    List<ActivityEntity> findActivitiesBetweenDates(Integer userId, Date beginDate, Date endDate);
}
