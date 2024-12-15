package org.example.helpme.repository;

import org.example.helpme.model.entity.CommentEntity;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface CommentRepository extends BaseRepository<CommentEntity, Integer> {
    // anyone

    List<CommentEntity> findByAnswerAnswerId(Integer answerId);

    List<CommentEntity> findByUserUserId(Integer userId);
}
