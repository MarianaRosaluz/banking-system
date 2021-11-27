package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Account;
import br.rosaluz.banking.system.model.Transfer;
import br.rosaluz.banking.system.repository.TransferRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransferRepository transferRepository;

    public TransferServiceImpl(AccountService accountService, TransferRepository transferRepository) {
        this.accountService = accountService;
        this.transferRepository = transferRepository;
    }

    @Override
    public boolean ValidateTransfer(TransferDTO transferDTO){

        if(ValidateAccount(transferDTO) && ValidateBalance(transferDTO)){
            return true;
        }else {
            return  false;
        }

    }
    @Override
    public Transfer save(Transfer transfer){
        return  transferRepository.save(transfer);
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
