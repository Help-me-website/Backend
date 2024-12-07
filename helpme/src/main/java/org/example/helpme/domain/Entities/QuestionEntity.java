package org.example.helpme.domain.Entities;


import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(nullable = false, length = 255)
    private String title;

    @Column(nullable = false)
    private String content;

    private Integer views = 0;

    private Integer numberOfUsers = 1;

    private LocalDateTime createdAt = LocalDateTime.now();

    private LocalDateTime updatedAt = LocalDateTime.now();

}
