package org.example.helpme.domain.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Table(name = "user")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "first_name", nullable = false, length = 50)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 50)
    private String lastName;

    @Column(name = "email", nullable = false, unique = true, length = 100)
    private String email;

    @Column(name = "password", nullable = false, length = 255)
    private String password;

    @Column(name = "reputation", nullable = false, columnDefinition = "int default 0")
    private Integer reputation;

    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false, columnDefinition = "ENUM('user', 'moderator', 'admin') default 'user'")
    private Role role;

    @Enumerated(EnumType.STRING)
    @Column(name = "account_status", nullable = false, columnDefinition = "ENUM('active', 'suspended', 'deactivated') default 'active'")
    private AccountStatus accountStatus;

    @Column(name = "profile_picture", columnDefinition = "TEXT")
    private String profilePicture;

    @Column(name = "bio", columnDefinition = "TEXT")
    private String bio;

    @Column(name = "last_login")
    private LocalDateTime lastLogin;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
    public enum AccountStatus {
        active,
        suspended,
        deactivated
    }
    public enum Role {
        user,
        moderator,
        admin
    }
}
