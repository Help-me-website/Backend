package org.example.helpme.repositories;

import org.example.helpme.domain.Entities.UserEntity;
import org.example.helpme.domain.dto.UserDTO;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends BaseRepo<UserEntity, Integer> {

}
