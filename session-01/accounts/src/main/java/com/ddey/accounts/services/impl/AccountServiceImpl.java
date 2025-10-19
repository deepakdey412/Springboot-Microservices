package com.ddey.accounts.services.impl;

import com.ddey.accounts.constants.AccountsConstants;
import com.ddey.accounts.dto.CustomerDto;
import com.ddey.accounts.entity.Accounts;
import com.ddey.accounts.entity.Customer;
import com.ddey.accounts.exception.CustomerAlreadyExist;
import com.ddey.accounts.mapper.CustomerMapper;
import com.ddey.accounts.repository.AccountRepository;
import com.ddey.accounts.repository.CustomerRepository;
import com.ddey.accounts.services.IAccountServices;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements IAccountServices {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    @Override
    public void createAccount(CustomerDto customerDto) {
        Customer customer = CustomerMapper.mapToCustomer(customerDto , new Customer());

        Optional<Customer> optinalCustomer = customerRepository
                .findByMobileNumberAndEmail(customer.getMobileNumber() , customer.getEmail());

        if (optinalCustomer.isPresent()){
            throw new CustomerAlreadyExist("Customer already exist with mobile number "+
                    customerDto.getMobileNumber());
        }

        Customer saveCustomer = customerRepository.save(customer);
        accountRepository.save(createNewAccount(saveCustomer));
    }

    private Accounts createNewAccount(Customer customer){
        Accounts newAccounts = new Accounts();
        newAccounts.setCustomerId(customer.getCustomerId());
        long randomAccountNumber = 1000000000L + new Random().nextInt(900000000);
        // generates 10-digit account numbers (1,000,000,000 - 1,899,999,999)
        newAccounts.setAccountNumber(randomAccountNumber);
        newAccounts.setAccountType(AccountsConstants.SAVINGS);
        newAccounts.setBranchAddress(AccountsConstants.ADDRESS);
        return newAccounts;
    }
}
