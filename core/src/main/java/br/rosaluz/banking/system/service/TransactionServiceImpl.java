package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Account;
import br.rosaluz.banking.system.model.Transaction;
import br.rosaluz.banking.system.repository.TransactionRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class TransactionServiceImpl implements TransactionService{



    @Autowired
    private TransactionRepository transactionRepository;

    public TransactionServiceImpl(TransactionRepository transactionRepository) {
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Transaction save(Transaction transaction){
        return transactionRepository.save(transaction);
    }

    @Override
    public List<Transaction> findByAccount(Long accountNumber){

        return transactionRepository.findByaccountNumber(accountNumber).get();

    }

}
