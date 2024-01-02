package org.unibl.etf.fitnessonline.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

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
    @JsonIgnore
    private List<ActivityEntity> activities;
    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private List<AdviceMessageEntity> adviceMessages;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CategorySubscriptionEntity> categorySubscriptions;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private List<MessageEntity> sentMessages;
    @OneToMany(mappedBy = "recipient")
    @JsonIgnore
    private List<MessageEntity> receivedMessages;
    @OneToMany(mappedBy = "creator")
    @JsonIgnore
    private List<ProgramEntity> programsCreated;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ProgramParticipationEntity> programParticipated;

}
