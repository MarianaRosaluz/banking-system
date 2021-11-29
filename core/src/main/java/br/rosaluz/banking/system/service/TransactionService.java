package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Transaction;

import java.util.List;

public interface TransactionService {

    public Transaction save(Transaction transaction);
    public List<Transaction> findByAccount(Long AccountNumber);
}
