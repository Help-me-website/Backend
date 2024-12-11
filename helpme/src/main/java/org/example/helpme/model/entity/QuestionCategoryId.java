package org.example.helpme.model.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class QuestionCategoryId implements Serializable {

    @Column(name = "question_id")
    private Integer questionId;

    @Column(name = "category_id")
    private Integer categoryId;
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
