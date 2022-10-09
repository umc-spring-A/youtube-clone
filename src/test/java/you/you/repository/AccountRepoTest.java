package you.you.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import you.you.domain.account.Account;
import you.you.domain.account.AccountRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class AccountRepoTest {

    @Autowired
    private AccountRepository accountRepository;

    @Test
    @DisplayName("사용자가 DB에 저장이 잘 되는지 확인")
    void saveUser(){
        Account account = Account.builder()
                .email("test@naver.com")
                .build();
        Account ret = accountRepository.save(account);
        assertThat(ret).isNotNull();
    }
}
