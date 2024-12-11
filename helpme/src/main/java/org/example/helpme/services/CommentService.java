package org.example.helpme.services;

import org.example.helpme.model.entity.CommentEntity;
import org.example.helpme.repository.CommentRepository;

public class CommentService {
    private final CommentRepository commentRepository;
    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }
    public Iterable<CommentEntity> getAllComments() {
        return commentRepository.findAll();
    }
    public void addComment(CommentEntity comment) {
        commentRepository.save(comment);
    }
    public void removeComment(CommentEntity comment) {
        commentRepository.delete(comment);
    }
    public void updateComment(CommentEntity comment) {
        commentRepository.save(comment);
    }
}
