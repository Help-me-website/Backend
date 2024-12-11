package org.example.helpme.repository;

import org.example.helpme.model.entity.QuestionEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepository extends BaseRepository<QuestionEntity, Integer> {
    // anyone
    List<QuestionEntity> findByUserUserId(Integer userId);

    @Query("SELECT q FROM QuestionEntity q WHERE q.title LIKE %?1%")
    List<QuestionEntity> findByTitleContaining(String keyword);
}
