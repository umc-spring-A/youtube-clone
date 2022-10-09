package org.study.youtube.dto.user;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserUpdateDto {

    private String originalPassword;
    private String newPassword;
    private String newPasswordConfirm;
}
