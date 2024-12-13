package org.example.helpme.service;

import org.example.helpme.mapper.UserMapper;
import org.example.helpme.model.dto.UserDTO;
import org.example.helpme.model.entity.AccountStatus;
import org.example.helpme.model.entity.Role;
import org.example.helpme.model.entity.UserEntity;
import org.example.helpme.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;
    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }
    public Iterable<UserDTO> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users
                .stream()
                .map(userMapper::toDto)
                .collect(Collectors.toList());
    }
    public void removeUser(Integer id) {
        userRepository.deleteById(id);
    }
    public Optional<UserDTO> updateUser(Integer userId, UserDTO userDTO) {
        return userRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setFirstName(userDTO.getFirstName());
                    existingUser.setLastName(userDTO.getLastName());
                    existingUser.setEmail(userDTO.getEmail());
                    existingUser.setBio(userDTO.getBio());
                    existingUser.setRole(Role.valueOf(userDTO.getRole()));
                    existingUser.setProfilePicture(userDTO.getProfilePicture());
                    existingUser.setAccountStatus(AccountStatus.valueOf(userDTO.getIsActive() ? "active" : "suspended"));
                    existingUser = userRepository.save(existingUser);
                    return userMapper.toDto(existingUser);
                });
    }
    public Optional<UserDTO> getUserById(Integer userId) {
        return userRepository.findById(userId)
                .map(userMapper::toDto);
    }

    public UserDTO getUserProfile(UserDTO user) {
        return userRepository.findById(user.getId())
                .map(userMapper::toDto)
                .orElseThrow(() -> new IllegalArgumentException("User not found"));
    }
}
