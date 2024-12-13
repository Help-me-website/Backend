package org.example.helpme.mapper;

import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.model.entity.QuestionEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface QuestionMapper {
    @Mapping(target = "id", source = "questionId")
    @Mapping(target = "userId", source = "user.userId")
    QuestionDTO toDto(QuestionEntity entity);

    @Mapping(target = "questionId", source = "id")
    @Mapping(target = "user.userId", source = "userId")
    QuestionEntity toEntity(QuestionDTO dto);
}
