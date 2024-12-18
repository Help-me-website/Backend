package org.example.helpme.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.AnswerDTO;
import org.example.helpme.model.entity.AnswerEntity;
import org.example.helpme.repository.AnswerRepository;
import org.example.helpme.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AnswerServiceIMPL implements AnswerService {
  private final AnswerRepository answerRepository;
  private final Mapper<AnswerEntity, AnswerDTO> answerMapper;

  @Override
  public Iterable<AnswerDTO> getAnswersByQuestionId(Integer questionId) {
    List<AnswerEntity> answers = answerRepository.findByQuestionQuestionId(questionId);
    return answers
            .stream()
            .map(answerMapper::toDto)
            .collect(Collectors.toList());
  }

  @Override
  public AnswerDTO saveAnswer(AnswerDTO answerDTO) {
    AnswerEntity answerEntity = answerMapper.toEntity(answerDTO);
    answerEntity = answerRepository.save(answerEntity);
    return answerMapper.toDto(answerEntity);
  }

  @Override
  public AnswerDTO updateAnswer(AnswerDTO answerDTO) {
    AnswerEntity answerEntity = answerMapper.toEntity(answerDTO);
    answerEntity = answerRepository.save(answerEntity);
    return answerMapper.toDto(answerEntity);
  }

  @Override
  public Void deleteAnswer(Integer id) {
    answerRepository.deleteById(id);
    return null;
  }

  @Override
  public AnswerDTO getById(Integer id) {
    AnswerEntity answerEntity = answerRepository.findByAnswerId(id).orElse(null);
    if(answerEntity == null) {
      return null;
    }
    return answerMapper.toDto(answerEntity);
  }

  @Override
  public Void acceptAnswer(Integer id, String username) {
    AnswerEntity answerEntity = answerRepository.findById(id).orElse(null);
    assert answerEntity != null;
    if (!answerEntity.getQuestion().getUser().getEmail().equals(username)) {
      throw new RuntimeException("You are not allowed to accept this answer");
    }
    answerEntity.setIsAccepted(true);
    answerRepository.save(answerEntity);
    return null;
  }
}
