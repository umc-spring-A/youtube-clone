package org.study.youtube.dto.user;

import lombok.Getter;
import lombok.Setter;
import org.study.youtube.entity.User;

@Getter
@Setter
public class UserDto {

    private String username;
    private String password;

    private String auth;

    public User toEntity() {
        return new User().builder()
                .username(username)
                .password(password)
                .auth(auth)
                .build();
    }
}
