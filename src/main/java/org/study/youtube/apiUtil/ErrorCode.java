package org.study.youtube.apiUtil;

public enum ErrorCode {
    FAIL(999,"실패"),
    NOT_FOUND_USER(450,"NOT_FOUND_USER"),
    UNAUTHORIZED(451,"UNAUTHORIZED");

    private int code;
    private String message;

    ErrorCode(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

   public String getMessage() {
        return message;
   }
}
