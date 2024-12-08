package org.example.helpme.domain.Entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class QuestionCategoryId implements Serializable {

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "category_id")
    private Integer categoryId;

    // Default constructor
    public QuestionCategoryId() {}

    // Constructor
    public QuestionCategoryId(Integer questionId, Integer categoryId) {
        this.questionId = questionId;
        this.categoryId = categoryId;
    }

    // Getters and Setters
    public Integer getQuestionId() {
        return questionId;
    }

    public void setQuestionId(Integer questionId) {
        this.questionId = questionId;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    // Equals and HashCode
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        QuestionCategoryId that = (QuestionCategoryId) o;
        return Objects.equals(questionId, that.questionId) &&
                Objects.equals(categoryId, that.categoryId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(questionId, categoryId);
    }
}
