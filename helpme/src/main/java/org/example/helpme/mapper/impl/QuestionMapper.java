package org.example.helpme.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.CategoryDTO;
import org.example.helpme.model.dto.QuestionDTO;
import org.example.helpme.model.entity.CategoryEntity;
import org.example.helpme.model.entity.QuestionEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class QuestionMapper implements Mapper<QuestionEntity, QuestionDTO> {
    private final ModelMapper modelMapper;

    @Override
    public QuestionDTO toDto(QuestionEntity questionEntity) {
        return modelMapper.map(questionEntity, QuestionDTO.class);
    }

    @Override
    public QuestionEntity toEntity(QuestionDTO questionDTO) {
        return modelMapper.map(questionDTO, QuestionEntity.class);
    }

}
