package org.example.helpme.repositories;

import org.example.helpme.domain.Entities.CommentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepo extends BaseRepo<CommentEntity, Integer> {
    // anyone
    List<CommentEntity> findByQuestionQuestionId(Integer questionId);

    List<CommentEntity> findByAnswerAnswerId(Integer answerId);

    List<CommentEntity> findByUserUserId(Integer userId);
}
