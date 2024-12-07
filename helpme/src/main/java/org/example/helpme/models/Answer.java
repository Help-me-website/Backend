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
public class Answer {
    private int id;
    private int questionId;
    private int userId;
    private String content;
    private boolean isAccepted;
    private Date createdAt;
    private Data updatedAt;
}
