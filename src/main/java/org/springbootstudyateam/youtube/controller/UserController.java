package org.springbootstudyateam.youtube.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    @PostMapping
    public String createUser() {

        return null;
    }

    @GetMapping("/{userId}")
    public String getUser(@PathVariable Long userId) {

        return null;
    }

    @PutMapping ("/{userId}")
    public String updateUser(@PathVariable Long userId) {
        return null;
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable Long userId) {
        return null;
    }
}
