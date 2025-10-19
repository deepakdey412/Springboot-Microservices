package com.ddey.accounts.mapper;

import com.ddey.accounts.dto.AccountDto;
import com.ddey.accounts.entity.Accounts;

public class AccountMapper {

    public static AccountDto mapToAccountDto(Accounts accounts, AccountDto accountDto) {
        accountDto.setAccountNumber(accounts.getAccountNumber());
        accountDto.setAccountType(accounts.getAccountType());
        accountDto.setBranchAddress(accounts.getBranchAddress());
        return accountDto;
    }

    public static Accounts mapToAccountsEntity(AccountDto accountDto, Accounts account) {
        account.setAccountNumber(accountDto.getAccountNumber());
        account.setAccountType(accountDto.getAccountType());
        account.setBranchAddress(accountDto.getBranchAddress());
        return account;
    }
}
