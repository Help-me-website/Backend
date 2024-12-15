package org.example.helpme.repository;

import org.example.helpme.model.entity.AnswerEntity;
import org.example.helpme.model.entity.QuestionEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AnswerRepository extends BaseRepository<AnswerEntity, Integer> {
    List<AnswerEntity> findByQuestionQuestionId(Integer questionId);
    Optional<AnswerEntity> findByAnswerId(Integer answerId);

    List<AnswerEntity> findByUserUserId(Integer userId);

    List<AnswerEntity> findByIsAcceptedTrue();
}
