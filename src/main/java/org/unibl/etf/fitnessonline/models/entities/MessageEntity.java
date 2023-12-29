package org.unibl.etf.fitnessonline.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Data
@Entity
@Table(name = "message", schema = "fitnessonline", catalog = "")
public class MessageEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "content", nullable = false, length = 45)
    private String content;
    @Basic
    @Column(name = "read", nullable = false)
    private boolean read;
    @ManyToOne
    @JoinColumn(name = "recipient_id", referencedColumnName = "id", nullable = false)
    private UserEntity recipient;
    @ManyToOne
    @JoinColumn(name = "sender_id", referencedColumnName = "id", nullable = false)
    private UserEntity sender;

}
