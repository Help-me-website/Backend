package org.example.helpme.repositories;

import org.example.helpme.domain.Entities.AnswerEntity;
import org.example.helpme.domain.dto.AnswerDTO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AnswerRepo extends BaseRepo<AnswerEntity, Integer> {
    List<AnswerEntity> findByQuestionQuestionId(Integer questionId);

    List<AnswerEntity> findByUserUserId(Integer userId);

    List<AnswerEntity> findByIsAcceptedTrue();
}
