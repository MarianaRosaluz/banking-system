package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Account;

public interface AccountService {
    public Account saveUser(Account account);
    public Account generateAccount();
}
