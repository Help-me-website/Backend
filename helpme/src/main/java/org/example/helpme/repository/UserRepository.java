package org.example.helpme.repository;

import org.example.helpme.model.entity.UserEntity;
import org.springframework.stereotype.Repository;

import javax.swing.text.html.Option;
import java.util.Optional;

@Repository
public interface UserRepository extends BaseRepository<UserEntity, Integer> {
    Optional<UserEntity> findByEmail(String email);
}
