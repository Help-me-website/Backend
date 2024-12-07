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
public class Question {
    private int questionId;
    private int userId;
    private String title;
    private String content;
    private int views;
    private int numberOfUsers;
    private Date createdAt;
    private Date updatedAt;
}
