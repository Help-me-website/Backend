package org.example.helpme.mapper;

import org.example.helpme.model.dto.CommentDTO;
import org.example.helpme.model.entity.CommentEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CommentMapper {
    @Mapping(target = "id", source = "commentId")
    @Mapping(target = "answerId", source = "answer.id")
    @Mapping(target = "userId", source = "user.id")
    @Mapping(target = "questionId", source = "question.id")
    CommentDTO toDto(CommentEntity comment);


    @Mapping(target = "commentId", source = "id")
    @Mapping(target = "answer.id", source = "answerId")
    @Mapping(target = "user.id", source = "userId")
    @Mapping(target = "question.id", source = "questionId")
    CommentEntity toEntity(CommentDTO commentDTO);
}
