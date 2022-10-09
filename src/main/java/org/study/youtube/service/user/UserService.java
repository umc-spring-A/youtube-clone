package org.study.youtube.service.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.study.youtube.dto.user.UserDto;
import org.study.youtube.dto.user.UserResponseDto;
import org.study.youtube.dto.user.UserUpdateDto;
import org.study.youtube.exception.user.ConfirmPasswordNotMatchedException;
import org.study.youtube.exception.user.UserNotFoundException;
import org.study.youtube.exception.user.WrongPasswordException;
import org.study.youtube.repository.UserRepository;
import org.study.youtube.entity.User;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    public Long save(UserDto userDto) {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
        return userRepository.save(userDto.toEntity()).getId();
    }

    @Transactional
    public void update(Long userId, UserUpdateDto userUpdateDto) throws UserNotFoundException, ConfirmPasswordNotMatchedException, WrongPasswordException {
        PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        User findUser = userRepository.findById(userId).orElseThrow(
                () -> new UserNotFoundException(userId)
        );

        //원 비밀번호 확인
        if(passwordEncoder.matches(userUpdateDto.getOriginalPassword(),findUser.getPassword())) {

            //비밀번호 변경 요청시
            if(userUpdateDto.getNewPassword() != null) {
                //새 비밀번호와 확인 비밀번호 비교
                if(userUpdateDto.getNewPassword().equals(userUpdateDto.getNewPasswordConfirm())) {
                    //변경
                    findUser.changePassword(passwordEncoder.encode(userUpdateDto.getNewPassword()));
                } else {
                    throw new ConfirmPasswordNotMatchedException();
                }
            }

        } else {
            throw new WrongPasswordException();
        }
    }

    public UserResponseDto get(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElseThrow(
                () -> new UserNotFoundException("해당 id를 가진 회원이 없습니다. : " + id)
        );

        return UserResponseDto.of(user);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findByUsername(username)
                .orElseThrow(()-> new UsernameNotFoundException(username));
    }
}
