package org.unibl.etf.fitnessonline.models.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "program_attribute")
public class ProgramAttributeEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "value", nullable = false, length = 45)
    private String value;
    @ManyToOne
    @JoinColumn(name = "program_id", referencedColumnName = "id", nullable = false)
    private ProgramEntity program;
    @ManyToOne
    @JoinColumn(name = "attribute_id", referencedColumnName = "id", nullable = false)
    private AttributeEntity attribute;

}
