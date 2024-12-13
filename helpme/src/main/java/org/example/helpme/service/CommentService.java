package org.example.helpme.service;

import org.example.helpme.mapper.CommentMapper;
import org.example.helpme.model.dto.CommentDTO;
import org.example.helpme.model.entity.CommentEntity;
import org.example.helpme.repository.CommentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class CommentService {
    private final CommentRepository commentRepository;
    private final CommentMapper commentMapper;
    public CommentService(CommentRepository commentRepository, CommentMapper commentMapper) {
        this.commentRepository = commentRepository;
        this.commentMapper = commentMapper;
    }
    public Iterable<CommentDTO> getAllComments() {
        List<CommentEntity> comments = commentRepository.findAll();
        return comments
                .stream()
                .map(commentMapper::toDto)
                .collect(Collectors.toList());
    }
    public void addComment(CommentDTO comment) {
        commentRepository.save(commentMapper.toEntity(comment));
    }
    public void removeComment(CommentDTO comment) {
        commentRepository.delete(commentMapper.toEntity(comment));
    }
    public void updateComment(CommentDTO comment) {
        commentRepository.save(commentMapper.toEntity(comment));
    }
}
