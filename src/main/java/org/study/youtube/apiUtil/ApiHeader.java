package org.study.youtube.apiUtil;

public class ApiHeader {

    private int resultCode;
    private String codeName;

    public ApiHeader(int resultCode, String codeName) {
        this.resultCode = resultCode;
        this.codeName = codeName;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getCodeName() {
        return codeName;
    }
}
