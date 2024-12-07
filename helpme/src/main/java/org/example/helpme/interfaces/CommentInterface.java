package org.example.helpme.interfaces;

import org.example.helpme.models.Comment;

import java.util.List;

public interface CommentInterface {
    // anyone
    public List<Comment> getComments();
    // must be a user
    public void addComment(Comment comment);
    public void removeComment(Comment comment);
    public void updateComment(Comment comment);
}
