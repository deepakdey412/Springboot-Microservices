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
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
public class AccountServiceImpl implements IAccountServices {

    private final CustomerRepository customerRepository;
    private final AccountRepository accountRepository;

    // Constructor for dependency injection (Lombok removed)
    public AccountServiceImpl(CustomerRepository customerRepository, AccountRepository accountRepository) {
        this.customerRepository = customerRepository;
        this.accountRepository = accountRepository;
    }

    @Override
    public void createAccount(CustomerDto customerDto) {
        // Map DTO to Entity
        Customer customer = CustomerMapper.mapToCustomer(customerDto, new Customer());

        // Check if customer already exists
        Optional<Customer> optionalCustomer = customerRepository
                .findByMobileNumberAndEmail(customer.getMobileNumber(), customer.getEmail());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExist("Customer already exists with mobile number "
                    + customerDto.getMobileNumber());
        }
        customer.setCreatedAt(LocalDateTime.now());
        customer.setUpdatedAt(LocalDateTime.now());

        // Save new customer
        Customer savedCustomer = customerRepository.save(customer);

        // Create and save account for the customer
        accountRepository.save(createNewAccount(savedCustomer));
    }

    // Helper method to create a new account
    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());

        // Generate a 10-digit random account number
        long randomAccountNumber = 1_000_000_000L + (long) new Random().nextInt(900_000_000);
        newAccount.setAccountNumber(randomAccountNumber);

        // Set timestamps
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setUpdatedAt(LocalDateTime.now());

        newAccount.setAccountType(AccountsConstants.SAVINGS);
        newAccount.setBranchAddress(AccountsConstants.ADDRESS);

        return newAccount;
    }
}
