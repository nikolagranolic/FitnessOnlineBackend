package org.unibl.etf.fitnessonline.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "category")
public class CategoryEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "name", nullable = false, length = 45)
    private String name;
    @OneToMany(mappedBy = "category")
    private List<AttributeEntity> attributes;
    @OneToMany(mappedBy = "category")
    private List<CategorySubscriptionEntity> subscriptions;
    @OneToMany(mappedBy = "category")
    private List<ProgramEntity> programs;

}
