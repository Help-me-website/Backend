package org.example.helpme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class AnswerDTO {
    private Integer id;
    private String content;
    private Integer questionId;
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Boolean isAccepted;
}
