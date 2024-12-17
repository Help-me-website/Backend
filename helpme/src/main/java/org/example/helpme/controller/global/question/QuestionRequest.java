package org.example.helpme.controller.global.question;

import lombok.*;
import org.example.helpme.model.dto.CategoryDTO;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class QuestionRequest {
    private String title;
    private String content;
    private CategoryRequest category;
}
class CategoryRequest{
    public Integer id;
    public String name;
}
