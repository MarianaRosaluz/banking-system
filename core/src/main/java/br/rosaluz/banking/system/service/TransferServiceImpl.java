package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Account;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class TransferServiceImpl implements TransferService{

    @Autowired
    private AccountService accountService;

    public TransferServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public boolean ValidateTransfer(TransferDTO transferDTO){

        if(ValidateAccount(transferDTO) && ValidateBalance(transferDTO)){
            return true;
        }else {
            return  false;
        }

    }
    public boolean ValidateAccount(TransferDTO transferDTO){

        if(accountService.findByaccountNumber(transferDTO.accountOrigin).isPresent() &&
                accountService.findByaccountNumber(transferDTO.accountDestination).isPresent()){
            return  true;
        }else {
            return false;
        }
    }
    public boolean ValidateBalance(TransferDTO transferDTO){
        Account account = new Account();
        Optional<Account> accountOptional = accountService.findByaccountNumber(transferDTO.accountOrigin);
        if(accountOptional.isPresent()){
             account = accountOptional.get();
        }
        if (account.getBalance() >= transferDTO.value) {
            return true;
        }else {
            return  false;
        }
    }


}
