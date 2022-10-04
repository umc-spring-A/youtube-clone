package org.springbootstudyateam.youtube.api.repository.user;

import org.springbootstudyateam.youtube.config.properties.entity.user.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUserId(String userId);
}