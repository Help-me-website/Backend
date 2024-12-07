package org.example.helpme.repositories;

import org.example.helpme.domain.dto.CommentDTO;

import java.util.List;

public interface CommentInterface {
    // anyone
    public List<CommentDTO> getComments();
    // must be a user
    public void addComment(CommentDTO commentDTO);
    public void removeComment(CommentDTO commentDTO);
    public void updateComment(CommentDTO commentDTO);
}
