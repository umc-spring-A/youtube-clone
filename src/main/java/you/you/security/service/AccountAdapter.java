package you.you.security.service;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import you.you.controller.dto.user.UserSessionDto;
import you.you.domain.account.Account;

import java.util.Collection;

public class AccountAdapter extends User {
    private final UserSessionDto user;

    public AccountAdapter(Account account, Collection<? extends GrantedAuthority> authorities) {
        super(account.getEmail(), account.getPassword(), authorities);
        //this.account = account;
        this.user = UserSessionDto.from(account);
    }

    public UserSessionDto getUser(){
        return this.user;
    }
}
