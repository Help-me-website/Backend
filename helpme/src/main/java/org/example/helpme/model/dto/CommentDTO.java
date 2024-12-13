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
public class CommentDTO {
    private Integer id;
    private String content;
    private Integer userId;
    private Integer questionId;
    private Integer answerId;
    private LocalDateTime createdAt;
}
