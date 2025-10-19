package com.ddey.accounts.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDto {
    private String apiPath;
    private String errorCode;
    private String errorMsg;
    private LocalDateTime errorTime;

}
