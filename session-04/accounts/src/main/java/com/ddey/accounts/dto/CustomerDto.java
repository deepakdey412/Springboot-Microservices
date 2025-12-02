package com.ddey.accounts.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public class CustomerDto {

    @NotEmpty(message = "Name can't be empty")
    @Size(min = 5 , max = 20 , message = "The length of the charecter should be between 5 to 20")
    private String name;
    @NotEmpty(message = "Email can't be empty")
    @Email(message = "Enter the valid email")
    private String email;
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    private AccountDto accountDto;

    // No-argument constructor
    public CustomerDto() {
    }

    // All-arguments constructor
    public CustomerDto(String name, String email, String mobileNumber, AccountDto accountDto) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accountDto = accountDto;
    }

    // Getters
    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    // Setters
    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }


    public AccountDto getAccountDto() {
        return accountDto;
    }

    public void setAccountDto(AccountDto accountDto) {
        this.accountDto = accountDto;
    }
}
