package org.example.helpme.repository;

import org.example.helpme.model.entity.QuestionEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends BaseRepository<QuestionEntity, Integer> {
    // anyone
    List<QuestionEntity> findByUserEmail(String email);
    List<QuestionEntity> findByUserUserId(Integer id);


    @Query("SELECT q FROM QuestionEntity q WHERE q.title LIKE %?1%")
    List<QuestionEntity> findByTitleContaining(String keyword);

    @Query("SELECT q FROM QuestionEntity q " +
            "JOIN q.questionCategories qc " +
            "JOIN qc.category c " +
            "WHERE c.name = :categoryName")
    List<QuestionEntity> findQuestionsByCategoryName(@Param("categoryName") String categoryName);
@Query("SELECT q FROM QuestionEntity q " +
        "JOIN q.questionCategories qc " +
        "JOIN qc.category c " +
        "WHERE c.name = :categoryName")
Page<QuestionEntity> findByCategory(@Param("categoryName") String categoryName, Pageable pageable);
    @Query("SELECT q FROM QuestionEntity q " +
            "WHERE LOWER(q.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(q.content) LIKE LOWER(CONCAT('%', :keyword, '%'))")
    Page<QuestionEntity> searchByKeyword(@Param("keyword") String keyword, Pageable pageable);

    @Query("SELECT q FROM QuestionEntity q " +
            "JOIN q.questionCategories qc " +
            "JOIN qc.category c " +
            "WHERE c.name = :categoryName " +
            "AND (LOWER(q.title) LIKE LOWER(CONCAT('%', :keyword, '%')) " +
            "OR LOWER(q.content) LIKE LOWER(CONCAT('%', :keyword, '%')))")
    Page<QuestionEntity> findByCategoryAndSearch(@Param("categoryName") String categoryName,
                                                 @Param("keyword") String keyword,
                                                 Pageable pageable);
}
