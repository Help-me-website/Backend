package org.example.helpme.service;

import org.example.helpme.model.dto.AnswerDTO;

public interface AnswerService {
  Iterable<AnswerDTO> getAnswersByQuestionId(Integer questionId);
  AnswerDTO saveAnswer(AnswerDTO answerDTO);
  AnswerDTO updateAnswer(AnswerDTO answerDTO);
  Void deleteAnswer(Integer id);
}
