package org.example.helpme.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CommentDTO {
    private int commentId;
    private int questionId;
    private int answerId;
    private int userId;
    private QuestionDTO questionDTO;
    private String content;
    private Date created;
}
