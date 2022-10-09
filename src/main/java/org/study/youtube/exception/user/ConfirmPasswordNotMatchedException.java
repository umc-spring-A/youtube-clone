package org.study.youtube.exception.user;

public class ConfirmPasswordNotMatchedException extends Exception{

    public ConfirmPasswordNotMatchedException() {
        super("확인 비밀번호가 같지 않습니다.");
    }
}
