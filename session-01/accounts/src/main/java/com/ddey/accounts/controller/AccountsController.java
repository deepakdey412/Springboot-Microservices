package com.ddey.accounts.controller;

import com.ddey.accounts.constants.AccountsConstants;
import com.ddey.accounts.dto.CustomerDto;
import com.ddey.accounts.dto.ResponseDto;
import com.ddey.accounts.services.IAccountServices;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping(path = "/api/accounts" , produces = {MediaType.APPLICATION_JSON_VALUE})
public class AccountsController {

    private final IAccountServices iAccountServices; // Service interface dependency will we added and but @Service will be added in the servie implementation class

    public AccountsController(IAccountServices iAccountServices) {
        this.iAccountServices = iAccountServices;
    }

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createAccount(@RequestBody CustomerDto customerDto) {
        iAccountServices.createAccount(customerDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(AccountsConstants.STATUS_201, AccountsConstants.MESSAGE_201));
    }


}
