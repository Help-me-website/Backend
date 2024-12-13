package org.example.helpme.mapper;

import org.example.helpme.model.dto.UserDTO;
import org.example.helpme.model.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.example.helpme.model.entity.AccountStatus;

@Mapper(componentModel = "spring")
public interface UserMapper {
    @Mapping(target = "id", source = "userId")
//    @Mapping(target = "isActive", expression = "java(userEntity.getAccountStatus() == AccountStatus.active)")
    UserDTO toDto(UserEntity userEntity);
    UserEntity toEntity(UserDTO userDTO);
}
