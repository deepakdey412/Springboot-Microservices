package com.ddey.accounts.dto;
//We can also use the mapper dependency instead of dta classes
public class ResponseDto {

    private String statusCode;
    private String statusMsg;

    // No-argument constructor
    public ResponseDto() {
    }

    // All-arguments constructor
    public ResponseDto(String statusCode, String statusMsg) {
        this.statusCode = statusCode;
        this.statusMsg = statusMsg;
    }

    // Getters
    public String getStatusCode() {
        return statusCode;
    }

    public String getStatusMsg() {
        return statusMsg;
    }

    // Setters
    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public void setStatusMsg(String statusMsg) {
        this.statusMsg = statusMsg;
    }
}
