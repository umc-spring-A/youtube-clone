package org.springbootstudyateam.youtube.api.service;

import lombok.RequiredArgsConstructor;
import org.springbootstudyateam.youtube.api.repository.user.UserRepository;
import org.springbootstudyateam.youtube.config.properties.entity.user.User;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
    private final UserRepository userRepository;

    public User getUser(String userId) {
        return userRepository.findByUserId(userId);
    }
}