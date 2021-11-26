package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Account;
import br.rosaluz.banking.system.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Random;

public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepository;


    public AccountServiceImpl(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Override
    public Account saveUser(Account account){
        return  accountRepository.save(account);
    }

    @Override
    public Account generateAccount(){
        Account account = new Account((long) 0001, generateAccountNumber(),generateAccountNumber());
        saveUser(account);
        return  account;
    }

    private Long generateAccountNumber(){
        Random generator = new Random();
        return (long) generator.nextInt(100000);
    }

}