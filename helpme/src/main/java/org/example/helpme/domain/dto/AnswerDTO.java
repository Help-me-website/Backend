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
public class AnswerDTO {
    private int id;
    private int questionId;
    private int userId;
    private String content;
    private boolean isAccepted;
    private Date createdAt;
    private Data updatedAt;
}
