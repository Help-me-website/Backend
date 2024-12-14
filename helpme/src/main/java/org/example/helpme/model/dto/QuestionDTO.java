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
public class QuestionDTO {
    private Integer id;
    private String title;
    private String content;
    private String category;
    private Integer userId;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer numberOfUsers;

}
