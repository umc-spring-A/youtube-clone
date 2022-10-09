package you.you.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import you.you.domain.User;
import you.you.domain.UserRepository;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class UserRepoTest {

    @Autowired
    private UserRepository userRepository;

    @Test
    @DisplayName("사용자가 DB에 저장이 잘 되는지 확인")
    void saveUser(){
        User user = User.builder()
                .email("test@naver.com")
                .build();
        User ret = userRepository.save(user);
        assertThat(ret).isNotNull();
    }
}
