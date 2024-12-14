package org.example.helpme.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.CommentDTO;
import org.example.helpme.model.entity.CommentEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CommentMapper implements Mapper<CommentEntity, CommentDTO> {
  private final ModelMapper modelMapper;
  @Override
  public CommentDTO toDto(CommentEntity commentEntity) {
    return modelMapper.map(commentEntity, CommentDTO.class);
  }

  @Override
  public CommentEntity toEntity(CommentDTO commentDTO) {
    return modelMapper.map(commentDTO, CommentEntity.class);
  }
}