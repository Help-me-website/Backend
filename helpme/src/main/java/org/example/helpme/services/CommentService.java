package org.example.helpme.services;

import org.example.helpme.domain.Entities.CommentEntity;
import org.example.helpme.repositories.CommentRepo;

public class CommentService {
    private final CommentRepo commentRepo;
    public CommentService(CommentRepo commentRepo) {
        this.commentRepo = commentRepo;
    }
    public Iterable<CommentEntity> getAllComments() {
        return commentRepo.findAll();
    }
    public void addComment(CommentEntity comment) {
        commentRepo.save(comment);
    }
    public void removeComment(CommentEntity comment) {
        commentRepo.delete(comment);
    }
    public void updateComment(CommentEntity comment) {
        commentRepo.save(comment);
    }
}
