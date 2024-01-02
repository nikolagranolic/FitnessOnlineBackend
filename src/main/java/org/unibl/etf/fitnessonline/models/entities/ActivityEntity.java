package org.unibl.etf.fitnessonline.models.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;

@Data
@Entity
@Table(name = "activity")
public class ActivityEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "exercise", nullable = false, length = 45)
    private String exercise;
    @Basic
    @Column(name = "duration", nullable = false)
    private int duration;
    @Basic
    @Column(name = "intensity", nullable = false, length = 45)
    private String intensity;
    @Basic
    @Column(name = "result", nullable = false)
    private int result;
    @Basic
    @Column(name = "date", nullable = false)
    private Date date;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

}
