package org.example.helpme.repositories;

import org.example.helpme.domain.dto.AnswerDTO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface AnswerRepo extends BaseRepo<AnswerDTO, Long> {
//    // anyone
//    public List<Answer> getAnswers();
//    // must be a user
//    public void addAnswer(Answer answer);
//    public void removeAnswer(Answer answer);
//    public void updateAnswer(Answer answer);
    @Query("SELECT a FROM AnswerEntity a WHERE a.questionId = ?1")
    List<AnswerDTO> getAnswersByQuestionId(Long questionId);
}
