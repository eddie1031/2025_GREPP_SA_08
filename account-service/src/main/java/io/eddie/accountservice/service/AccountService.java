package io.eddie.accountservice.service;


import io.eddie.accountservice.model.dto.CreateAccountRequest;
import io.eddie.accountservice.model.entity.Account;

public interface AccountService {

    Account create(CreateAccountRequest request);
    Account getByUsername(String username);
    Account getByAccountCode(String accountCode);

}
