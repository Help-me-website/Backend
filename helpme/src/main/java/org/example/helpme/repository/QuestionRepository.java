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

    List<QuestionEntity> findByCategoryCategoryId(Integer categoryId);
    List<QuestionEntity> findByCategory_Name(String categoryName);
    @Query("SELECT q FROM QuestionEntity q ORDER BY q.numberOfUsers DESC LIMIT 10")
    List<QuestionEntity> getFAQ();
}

