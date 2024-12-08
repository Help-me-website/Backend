package org.example.helpme.repositories;

import org.example.helpme.domain.Entities.QuestionEntity;
import org.example.helpme.domain.dto.QuestionDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface QuestionRepo extends BaseRepo<QuestionEntity, Integer> {
    // anyone
    List<QuestionEntity> findByUserUserId(Integer userId);

    @Query("SELECT q FROM QuestionEntity q WHERE q.title LIKE %?1%")
    List<QuestionEntity> findByTitleContaining(String keyword);
}
