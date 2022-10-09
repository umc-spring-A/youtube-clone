package org.study.youtube.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.study.youtube.entity.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    Optional<User> findByUsername(String username);
}
