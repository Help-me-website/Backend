package org.example.helpme.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.AnswerDTO;
import org.example.helpme.model.entity.AnswerEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class AnswerMapper implements Mapper<AnswerEntity, AnswerDTO> {
  private final ModelMapper modelMapper;
  @Override
  public AnswerDTO toDto(AnswerEntity answerEntity) {
    return modelMapper.map(answerEntity, AnswerDTO.class);
  }
  @Override
  public AnswerEntity toEntity(AnswerDTO answerDTO) {
    return modelMapper.map(answerDTO, AnswerEntity.class);
  }
}
