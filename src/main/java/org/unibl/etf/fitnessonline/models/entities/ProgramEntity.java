package org.unibl.etf.fitnessonline.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

@Data
@Entity
@Table(name = "program")
public class ProgramEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
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
    @Column(name = "price", nullable = false, precision = 2)
    private BigDecimal price;
    @Basic
    @Column(name = "difficulty", nullable = false, length = 45)
    private String difficulty;
    @OneToMany(mappedBy = "programByProgramId")
    @JsonIgnore
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "programByProgramId")
    @JsonIgnore
    private List<ImageEntity> images;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", referencedColumnName = "id", nullable = false)
    private CategoryEntity category;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", referencedColumnName = "id", nullable = false)
    private UserEntity user;
    @OneToMany(mappedBy = "program")
    @JsonIgnore
    private List<ProgramAttributeEntity> programAttributes;
    @OneToMany(mappedBy = "program")
    @JsonIgnore
    private List<ProgramParticipationEntity> programParticipations;

}
