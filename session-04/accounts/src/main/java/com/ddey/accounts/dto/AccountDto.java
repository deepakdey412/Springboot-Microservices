package com.ddey.accounts.dto;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;

public class AccountDto {

    @NotEmpty(message = "Account number can not be emplty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Account number must be 12 digits")
    private Long accountNumber;
    @NotEmpty(message = "Account type can not be emplty")
    private String accountType;
    @NotEmpty(message = "Account branch Addres can not be emplty")
    private String branchAddress;

    // No-argument constructor
    public AccountDto() {
    }

    // All-arguments constructor
    public AccountDto(Long accountNumber, String accountType, String branchAddress) {
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.branchAddress = branchAddress;
    }

    // Getters
    public Long getAccountNumber() {
        return accountNumber;
    }

    public String getAccountType() {
        return accountType;
    }

    public String getBranchAddress() {
        return branchAddress;
    }

    // Setters
    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public void setBranchAddress(String branchAddress) {
        this.branchAddress = branchAddress;
    }
}
