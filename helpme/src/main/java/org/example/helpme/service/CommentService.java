package org.example.helpme.service;

import lombok.RequiredArgsConstructor;
import org.example.helpme.model.dto.CommentDTO;
import org.springframework.stereotype.Service;

public interface CommentService {
  public Iterable<CommentDTO> getCommentsByAnswerId(Integer answerId);
  public CommentDTO createComment(CommentDTO commentDTO);

  public CommentDTO getCommentById(Integer commentId);
  public CommentDTO updateComment(CommentDTO commentDTO);
  public void deleteComment(Integer commentId);
}
