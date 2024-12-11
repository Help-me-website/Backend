package org.example.helpme.repository;

import org.example.helpme.model.entity.QuestionCategoryEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionCategoryRepository extends BaseRepository<QuestionCategoryEntity, Integer> {
    List<QuestionCategoryEntity> findByQuestionQuestionId(Integer questionId);

    List<QuestionCategoryEntity> findByCategoryCategoryId(Integer categoryId);
    @Query("SELECT qc FROM QuestionCategoryEntity qc WHERE qc.category.categoryId = ?1 AND qc.question.questionId = ?2")
    List<QuestionCategoryEntity> findByCategoryIdAndQuestionId(Integer categoryId, Integer questionId);

}
