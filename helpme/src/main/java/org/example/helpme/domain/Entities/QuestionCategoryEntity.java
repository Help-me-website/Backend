package org.example.helpme.domain.Entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "questionCategory")
public class QuestionCategoryEntity {
    @Id
    private Long id;
    private Long question_id;
    private Long category_id;
}
