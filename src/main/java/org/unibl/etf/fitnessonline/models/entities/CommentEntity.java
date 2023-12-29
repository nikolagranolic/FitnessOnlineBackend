package org.unibl.etf.fitnessonline.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "comment", schema = "fitnessonline", catalog = "")
public class CommentEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "content", nullable = false, length = -1)
    private String content;
    @Basic
    @Column(name = "datetime", nullable = false)
    private Timestamp datetime;
    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    private ProgramEntity program;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;

}
