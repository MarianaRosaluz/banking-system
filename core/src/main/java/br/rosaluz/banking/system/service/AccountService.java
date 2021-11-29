package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Account;

import java.util.Optional;

public interface AccountService {
    public Account save(Account account);
    public Account generateAccount();
    public Optional<Account> findByaccountNumber(Long accountNumber);
    public  Double getBalance(Long accountNumber);
}
