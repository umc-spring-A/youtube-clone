package you.you.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import you.you.controller.dto.user.UserSessionDto;
import you.you.controller.dto.user.UserSignupDto;
import you.you.domain.account.Account;
import you.you.domain.account.AccountRepository;

@Service
public class UserService {
    private AccountRepository accountRepository;
    private PasswordEncoder passwordEncoder;
    @Autowired
    public UserService(AccountRepository accountRepository, PasswordEncoder passwordEncoder) {
        this.accountRepository = accountRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public UserSessionDto findUserBy(Long userId) throws Exception {
        Account user = accountRepository.findById(userId)
                //.orElseThrow(UserNotFoundException::new);
                .orElseThrow(Exception::new);
        return toDto(user);
    }

    public void registerUser(UserSignupDto userDto) throws Exception {
        try {
            Account user = toEntity(userDto);
            user.setPassword(passwordEncoder.encode(user.getPassword()));
            accountRepository.save(user);
        } catch(DataIntegrityViolationException e){ // 무결성 조건 (중복) - 이메일
            //throw new DuplicateUserException();
            throw new Exception();
        }
    }


    private Account findById(Long userId) throws Exception {
        return accountRepository.findById(userId)
                //.orElseThrow(UserNotFoundException::new);
                .orElseThrow(Exception::new);

    }
    public Account toEntity(UserSignupDto userDto){
        return Account.builder().
                email(userDto.getEmail())
                .password(userDto.getPassword())
                .build();
    }

    private UserSessionDto toDto(Account user) {
        return UserSessionDto.builder()
                .id(user.getId())
                .email(user.getEmail())
                .build();
    }
}
