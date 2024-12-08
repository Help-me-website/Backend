package org.example.helpme.domain.Entities;


import jakarta.persistence.*;


import java.time.LocalDateTime;

@Entity
@Table(name = "question")
public class QuestionEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "question_id")
    private Integer questionId;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @Column(name = "title", nullable = false, length = 255)
    private String title;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "views", nullable = false, columnDefinition = "int default 0")
    private Integer views;

    @Column(name = "number_of_users", nullable = false, columnDefinition = "int default 1")
    private Integer numberOfUsers;

    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(name = "updated_at")
    private LocalDateTime updatedAt;
}
