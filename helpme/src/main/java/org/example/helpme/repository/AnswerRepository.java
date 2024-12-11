package org.example.helpme.repository;

import org.example.helpme.model.entity.AnswerEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepository extends BaseRepository<AnswerEntity, Integer> {
    List<AnswerEntity> findByQuestionQuestionId(Integer questionId);

    List<AnswerEntity> findByUserUserId(Integer userId);

    List<AnswerEntity> findByIsAcceptedTrue();
}
