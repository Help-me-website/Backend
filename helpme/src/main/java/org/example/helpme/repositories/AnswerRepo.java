package org.example.helpme.repositories;

import org.example.helpme.domain.Entities.AnswerEntity;
import org.example.helpme.domain.dto.AnswerDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface AnswerRepo extends BaseRepo<AnswerEntity, Long> {
}
