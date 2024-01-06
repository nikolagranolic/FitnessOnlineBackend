package org.unibl.etf.fitnessonline.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.unibl.etf.fitnessonline.models.roles.Role;

import java.util.Collection;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "user")
public class UserEntity implements UserDetails {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;
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
    @Column(name = "password", nullable = false, length = 100)
    private String password;
    @Basic
    @Column(name = "avatar", nullable = true, length = -1)
    private String avatar;
    @Basic
    @Column(name = "email", nullable = false, length = 45)
    private String email;
    @Basic
    @Column(name = "verification_token", nullable = true, length = 300)
    private String verificationToken;
    @Basic
    @Column(name = "activated", nullable = false)
    private Boolean activated;
    @Basic
    @Column(name = "verified", nullable = false)
    private Boolean verified;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ActivityEntity> activities;
    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private List<AdviceMessageEntity> adviceMessages;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<CategorySubscriptionEntity> categorySubscriptions;
    @OneToMany(mappedBy = "userByUserId")
    @JsonIgnore
    private List<CommentEntity> comments;
    @OneToMany(mappedBy = "sender")
    @JsonIgnore
    private List<MessageEntity> sentMessages;
    @OneToMany(mappedBy = "recipient")
    @JsonIgnore
    private List<MessageEntity> receivedMessages;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ProgramEntity> programCreations;
    @OneToMany(mappedBy = "user")
    @JsonIgnore
    private List<ProgramParticipationEntity> programParticipations;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(Role.ROLE_USER.name()));
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
