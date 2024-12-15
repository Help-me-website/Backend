package org.example.helpme.model.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.helpme.model.entity.CategoryEntity;

import java.time.LocalDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionDTO {
    private Integer id;
    private String title;
    private String content;
    private CategoryDTO category;
    private Integer userId;
    private Integer views;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private Integer numberOfUsers;

}
