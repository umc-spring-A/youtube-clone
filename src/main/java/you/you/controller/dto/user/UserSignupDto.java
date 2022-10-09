package you.you.controller.dto.user;

import com.sun.istack.NotNull;
import lombok.Builder;
import lombok.Getter;

import javax.validation.constraints.Email;

@Getter
@Builder
public class UserSignupDto {

    @NotNull
    @Email(message = "이메일 형식을 따르지 못했습니다.")
    String email;
    @NotNull String password;
}
