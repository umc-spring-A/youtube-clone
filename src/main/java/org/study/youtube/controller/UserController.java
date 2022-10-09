package org.study.youtube.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.study.youtube.apiUtil.ApiResponse;
import org.study.youtube.apiUtil.ErrorCode;
import org.study.youtube.dto.user.UserDto;
import org.study.youtube.dto.user.UserUpdateDto;
import org.study.youtube.exception.user.ConfirmPasswordNotMatchedException;
import org.study.youtube.exception.user.UserNotFoundException;
import org.study.youtube.exception.user.WrongPasswordException;
import org.study.youtube.service.user.UserService;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    @GetMapping("/{userId}")
    public ApiResponse getUser(@PathVariable Long userId) {

        log.info("getUser : {}",userId);
        try {
            return ApiResponse.OK(userService.get(userId));
        } catch (UserNotFoundException e) {
            return ApiResponse.fail(ErrorCode.NOT_FOUND_USER);
        }
    }

    @PostMapping
    public ApiResponse createUser(@ModelAttribute UserDto userDto) {

        log.info("createUser : {} {}",userDto.getUsername(), userDto.getAuth());
        Long id = userService.save(userDto);

        try {
            return ApiResponse.OK(userService.get(id));
        } catch (UserNotFoundException e) {
            return ApiResponse.fail(ErrorCode.FAIL);
        }
    }

    @PutMapping("/{userId}")
    public ApiResponse updateUser(@PathVariable Long userId,
            @ModelAttribute UserUpdateDto userUpdateDto) {
        log.info("updateUser : {}",userId);

        try {
            userService.update(userId,userUpdateDto);
            return ApiResponse.OK();

        } catch (UserNotFoundException e) {
            return ApiResponse.fail(ErrorCode.NOT_FOUND_USER);
        } catch (ConfirmPasswordNotMatchedException e) {
            return ApiResponse.fail(ErrorCode.FAIL,e.getMessage());
        } catch (WrongPasswordException e) {
            return ApiResponse.fail(ErrorCode.FAIL,e.getMessage());
        }
    }

    @DeleteMapping("/{userId}")
    public ApiResponse deleteUser(@PathVariable Long userId) {
        log.info("deleteUser : {}",userId);
        userService.delete(userId);
        return ApiResponse.OK();
    }
}
