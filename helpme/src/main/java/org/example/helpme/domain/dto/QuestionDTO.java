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
public class QuestionDTO {
    private int questionId;
    private int userId;
    private String title;
    private String content;
    private int views;
    private int numberOfUsers;
    private Date createdAt;
    private Date updatedAt;
}