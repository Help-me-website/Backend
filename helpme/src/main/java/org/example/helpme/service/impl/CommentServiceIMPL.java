package org.example.helpme.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.mapper.impl.CommentMapper;
import org.example.helpme.model.dto.CommentDTO;
import org.example.helpme.model.entity.CommentEntity;
import org.example.helpme.repository.CommentRepository;
import org.example.helpme.service.CommentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceIMPL implements CommentService {
  private final CommentRepository commentRepository;
  private final Mapper<CommentEntity, CommentDTO> commentMapper;

  @Override
  public Iterable<CommentDTO> getCommentsByAnswerId(Integer answerId) {
    List<CommentEntity> comments = commentRepository.findByAnswerAnswerId(answerId);
    return comments
            .stream()
            .map(commentMapper::toDto)
            .collect(Collectors.toList());
  }

  @Override
  public CommentDTO createComment(CommentDTO commentDTO) {
    CommentEntity commentEntity = commentMapper.toEntity(commentDTO);
    commentEntity = commentRepository.save(commentEntity);
    return commentMapper.toDto(commentEntity);
  }

  @Override
  public CommentDTO getCommentById(Integer commentId) {
    return commentRepository.findById(commentId).map(commentMapper::toDto).orElse(null);
  }

  @Override
  public CommentDTO updateComment(CommentDTO commentDTO) {
    CommentEntity commentEntity = commentMapper.toEntity(commentDTO);
    commentEntity = commentRepository.save(commentEntity);
    return commentMapper.toDto(commentEntity);
  }

  @Override
  public void deleteComment(Integer commentId) {
    commentRepository.deleteById(commentId);
  }
}
