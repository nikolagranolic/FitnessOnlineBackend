package org.unibl.etf.fitnessonline.models.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Objects;

@Data
@Entity
@Table(name = "user")
public class UserEntity {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private int id;
    @Basic
    @Column(name = "first_name", nullable = false, length = 45)
    private String firstName;
    @Basic
    @Column(name = "last_name", nullable = false, length = 45)
    private String lastName;
    @Basic
    @Column(name = "city", nullable = false, length = 45)
    private String city;
    @Basic
    @Column(name = "username", nullable = false, length = 45)
    private String username;
    @Basic
    @Column(name = "password", nullable = false, length = 45)
    private String password;
    @Basic
    @Column(name = "avatar", nullable = true, length = 45)
    private String avatar;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic
    @Column(name = "activated", nullable = false)
    private boolean activated;
    @OneToMany(mappedBy = "user")
    private List<ActivityEntity> activities;
    @OneToMany(mappedBy = "user")
    private List<AdviceMessageEntity> adviceMessages;
    @OneToMany(mappedBy = "user")
    private List<CategorySubscriptionEntity> subscriptions;
    @OneToMany(mappedBy = "user")
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "recipient")
    private List<MessageEntity> receivedMessages;
    @OneToMany(mappedBy = "user")
    private List<ProgramParticipationEntity> participations;
    @OneToMany(mappedBy = "sender")
    private List<MessageEntity> sentMessages;

}
