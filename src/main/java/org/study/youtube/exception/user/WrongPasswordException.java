package org.study.youtube.exception.user;

public class WrongPasswordException extends Exception{
    public WrongPasswordException() {
        super("비밀번호가 맞지 않습니다.");
    }
}
