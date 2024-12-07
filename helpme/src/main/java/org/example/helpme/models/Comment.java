package org.example.helpme.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Comment {
    private int commentId;
    private int questionId;
    private int answerId;
    private int userId;
    private Question question;
    private String content;
    private Date created;
}
