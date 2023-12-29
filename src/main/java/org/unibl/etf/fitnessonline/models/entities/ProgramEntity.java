package org.unibl.etf.fitnessonline.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "program", schema = "fitnessonline", catalog = "")
public class ProgramEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @Basic
    @Column(name = "description", nullable = false, length = -1)
    private String description;
    @Basic
    @Column(name = "location", nullable = false, length = 45)
    private String location;
    @Basic
    @Column(name = "instructor", nullable = false, length = 45)
    private String instructor;
    @Basic
    @Column(name = "contact", nullable = false, length = 45)
    private String contact;
    @Basic
    @Column(name = "video", nullable = true, length = 200)
    private String video;
    @Basic
    @Column(name = "begin_date", nullable = false)
    private Date beginDate;
    @Basic
    @Column(name = "end_date", nullable = false)
    private Date endDate;
    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    private int price;
    @Basic
    @Column(name = "difficulty", nullable = false, length = 45)
    private String difficulty;
    @OneToMany(mappedBy = "program")
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "program")
    private List<ImageEntity> images;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;
    @OneToMany(mappedBy = "program")
    private List<ProgramParticipationEntity> participations;

}
