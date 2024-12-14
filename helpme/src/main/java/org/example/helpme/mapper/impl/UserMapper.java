package org.example.helpme.mapper.impl;

import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.UserDTO;
import org.example.helpme.model.entity.AccountStatus;
import org.example.helpme.model.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class UserMapper implements Mapper<UserEntity, UserDTO> {
  private final ModelMapper modelMapper;

  public UserMapper(ModelMapper modelMapper) {
    this.modelMapper = modelMapper;
  }

  public UserDTO toDto(UserEntity userEntity) {
    UserDTO userDTO = modelMapper.map(userEntity, UserDTO.class);

    // Map custom fields if necessary
    userDTO.setIsActive(userEntity.getAccountStatus() != null &&
            userEntity.getAccountStatus() == AccountStatus.active);
    return userDTO;
  }

  public UserEntity toEntity(UserDTO userDTO) {
    UserEntity userEntity = modelMapper.map(userDTO, UserEntity.class);

    // Map custom fields if necessary
    userEntity.setAccountStatus(userDTO.getIsActive() ? AccountStatus.active : AccountStatus.suspended);
    return userEntity;
  }

}
