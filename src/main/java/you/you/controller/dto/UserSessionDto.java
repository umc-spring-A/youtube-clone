package you.you.controller.dto;

import lombok.Builder;
import lombok.Getter;
import you.you.domain.account.Account;

import java.io.Serializable;

@Getter
@Builder
public class UserSessionDto implements Serializable {
    Long id;
    String email;

    public static UserSessionDto from(Account account){
        return UserSessionDto.builder()
                .id(account.getId())
                .email(account.getEmail())
                .build();
    }
}
