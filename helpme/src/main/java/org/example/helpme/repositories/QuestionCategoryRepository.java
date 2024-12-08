package org.example.helpme.repositories;

import org.example.helpme.domain.Entities.QuestionCategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionCategoryRepository extends BaseRepo<QuestionCategoryEntity, Integer> {
    List<QuestionCategoryEntity> findByQuestionQuestionId(Integer questionId);

    List<QuestionCategoryEntity> findByCategoryCategoryId(Integer categoryId);
    @Query("SELECT qc FROM QuestionCategoryEntity qc WHERE qc.category.categoryId = ?1 AND qc.question.questionId = ?2")
    List<QuestionCategoryEntity> findByCategoryIdAndQuestionId(Integer categoryId, Integer questionId);

}
