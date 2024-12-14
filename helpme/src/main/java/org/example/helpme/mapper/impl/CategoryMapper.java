package org.example.helpme.mapper.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.CategoryDTO;
import org.example.helpme.model.entity.CategoryEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class CategoryMapper implements Mapper<CategoryEntity, CategoryDTO> {
  private final ModelMapper modelMapper;

  @Override
  public CategoryDTO toDto(CategoryEntity categoryEntity) {
    return modelMapper.map(categoryEntity, CategoryDTO.class);
  }
  @Override
  public CategoryEntity toEntity(CategoryDTO categoryDTO) {
    return modelMapper.map(categoryDTO, CategoryEntity.class);
  }
}
