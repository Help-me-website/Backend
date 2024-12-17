package org.example.helpme.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.helpme.controller.user.UserUpdate;
import org.example.helpme.mapper.Mapper;
import org.example.helpme.model.dto.UserDTO;
import org.example.helpme.model.entity.AccountStatus;
import org.example.helpme.model.entity.Role;
import org.example.helpme.model.entity.UserEntity;
import org.example.helpme.repository.UserRepository;
import org.example.helpme.service.UserService;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
@RequiredArgsConstructor
public class UserServiceIMPL implements UserService {
  private final UserRepository userRepository;
  private final Mapper<UserEntity, UserDTO> userMapper;

  public Iterable<UserDTO> getAllUsers() {
    List<UserEntity> users = userRepository.findAll();
    return users
            .stream()
            .map(userMapper::toDto)
            .collect(Collectors.toList());
  }

  @Override
  public UserDTO getUserById(Integer id) {
    return userMapper.toDto(userRepository.findById(id).orElse(null));
  }

  @Override
  public UserDTO saveUser(UserDTO userDTO) {
    UserEntity userEntity = userMapper.toEntity(userDTO);
    userEntity = userRepository.save(userEntity);
    return userMapper.toDto(userEntity);
  }

  @Override
  public Optional<UserDTO> updateUser(String username, UserDTO userDTO) {
    return userRepository.findByEmail(username)
            .map(existingUser -> {
              existingUser.setFirstName(userDTO.getFirstName());
              existingUser.setLastName(userDTO.getLastName());
              existingUser.setEmail(userDTO.getEmail());
              existingUser.setBio(userDTO.getBio());
              existingUser.setRole(Role.valueOf(userDTO.getRole()));
              existingUser.setProfilePicture(userDTO.getProfilePicture());
              existingUser.setAccountStatus(userDTO.getIsActive() ? AccountStatus.active : AccountStatus.suspended);
              existingUser = userRepository.save(existingUser);
              return userMapper.toDto(existingUser);
            });
  }

  @Override
  public void deleteUser(String username) {
    UserEntity user =  userRepository.findByEmail(username).orElse(null);
    assert user != null;
    userRepository.deleteById(user.getUserId());
  }

  @Override
  public UserDTO loadUserByEmail(String email) {
    return userMapper.toDto(userRepository.findByEmail(email).orElse(null));
  }
  @Override
  public Optional<UserDTO> updateUser(String username, UserUpdate updatedUser) {
    UserEntity user = userRepository.findByEmail(username).orElse(null);
    assert user != null;
    user.setFirstName(updatedUser.getFirstname());
    user.setLastName(updatedUser.getLastname());
    userRepository.save(user);
    return Optional.of(userMapper.toDto(user));
  }

}
