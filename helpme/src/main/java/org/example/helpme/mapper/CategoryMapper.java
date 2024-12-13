package org.example.helpme.mapper;

import org.example.helpme.model.dto.CategoryDTO;
import org.example.helpme.model.entity.CategoryEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CategoryMapper {
    @Mapping(target = "id", source = "categoryId")
    CategoryDTO toDto(CategoryEntity categoryEntity);
    @Mapping(target = "categoryId", source = "id")
    CategoryEntity toEntity(CategoryDTO categoryDTO);
}
