package com.ddey.accounts.services;

import com.ddey.accounts.dto.CustomerDto;
import com.ddey.accounts.entity.Customer;

public interface IAccountServices {
    void createAccount(CustomerDto customerDto);
    CustomerDto fetchAccount(String mobileNumber);
    boolean updateAccount(CustomerDto customerDto);
    boolean deleteAccount(String mobileNumber);
}
