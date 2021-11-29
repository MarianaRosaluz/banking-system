package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.TransferDTO;
import br.rosaluz.banking.system.model.Account;
import br.rosaluz.banking.system.model.Payment;
import br.rosaluz.banking.system.model.Transaction;
import br.rosaluz.banking.system.model.Transfer;
import br.rosaluz.banking.system.repository.TransferRepository;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class TransferServiceImpl implements TransferService{

    @Autowired
    private AccountService accountService;
    @Autowired
    private TransferRepository transferRepository;

    @Autowired
    private TransactionService transactionService;

    public TransferServiceImpl(AccountService accountService, TransferRepository transferRepository, TransactionService transactionService) {
        this.accountService = accountService;
        this.transferRepository = transferRepository;
        this.transactionService = transactionService;
    }

    @Override
    public  boolean makeTransfer(TransferDTO transferDTO){

        if (ValidateTransfer(transferDTO)){

            Double OldBalanceOrigin = accountService.getBalance(transferDTO.accountOrigin);
            Double NewBalanceOrigin = OldBalanceOrigin - transferDTO.value;
            Optional <Account> accountOptionalOrigin = accountService.findByaccountNumber(transferDTO.accountOrigin);
            Account accountOrigin = accountOptionalOrigin.get();
            accountOrigin.setBalance(NewBalanceOrigin);
            accountService.save(accountOrigin);

            Double OldBalance = accountService.getBalance(transferDTO.accountDestination);
            Double NewBalance = OldBalance + transferDTO.value;
            Optional <Account> accountOptional = accountService.findByaccountNumber(transferDTO.accountDestination);
            Account accountDestination = accountOptional.get();
            accountDestination.setBalance(NewBalance);
            accountService.save(accountDestination);



            Transfer transfer = transferDTO.convertToTransfer();
            save(transfer);
            transactionService.save(new Transaction("transfer","Debit", transfer.getValue(),transfer.getAccountOrigin()));
            transactionService.save(new Transaction("transfer","Credit", transfer.getValue(),transfer.getAccountDestination()));
            return  true;
        }
        return  false;

    }

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
