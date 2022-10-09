package org.study.youtube.dto.user;

import lombok.*;
import org.study.youtube.entity.User;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UserResponseDto {

    private String username;
    private String auth;

    public static UserResponseDto of(User user) {
        return new UserResponseDto().builder()
                .username(user.getUsername())
                .auth(user.getAuth())
                .build();
    }
}
