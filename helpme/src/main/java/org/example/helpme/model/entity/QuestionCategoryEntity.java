package org.example.helpme.model.entity;


import jakarta.persistence.*;

@Entity
@Table(name = "QuestionCategory")
public class QuestionCategoryEntity {
    @EmbeddedId
    private QuestionCategoryId id;

    @MapsId("questionId")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "question_id", nullable = false)
    private QuestionEntity question;

    @MapsId("categoryId") 
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;
}
