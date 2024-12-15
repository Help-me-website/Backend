package org.example.helpme.service;

import org.example.helpme.model.dto.AnswerDTO;

import java.util.Optional;

public interface AnswerService {
  Iterable<AnswerDTO> getAnswersByQuestionId(Integer questionId);
  AnswerDTO saveAnswer(AnswerDTO answerDTO);
  AnswerDTO updateAnswer(AnswerDTO answerDTO);
  AnswerDTO getById(Integer id);
  Void deleteAnswer(Integer id);
  Void acceptAnswer(Integer id,String username);
}
