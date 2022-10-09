package org.study.youtube.exception.user;

public class UserNotFoundException extends Exception{

    public UserNotFoundException(String message) {
        super("유저를 찾을 수 없습니다. : "+message);
    }

    public UserNotFoundException(Long userId) {
        super("유저를 찾을 수 없습니다.  id : "+ userId);
    }


}
