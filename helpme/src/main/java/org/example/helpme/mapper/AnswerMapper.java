package org.example.helpme.mapper;

import org.example.helpme.model.dto.AnswerDTO;
import org.example.helpme.model.entity.AnswerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AnswerMapper {
    @Mapping(target = "questionId", source = "question.questionId")
    @Mapping(target = "userId", source = "user.userId")
    @Mapping(target = "id", source = "answerId")
    AnswerDTO toDto(AnswerEntity entity);

    @Mapping(target = "question.questionId", source = "questionId")
    @Mapping(target = "user.userId", source = "userId")
    @Mapping(target = "answerId", source = "id")
    AnswerEntity toEntity(AnswerDTO dto);
}
