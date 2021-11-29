package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.model.Institution;

import java.util.Optional;

public interface BankService  {

    public Bank save(Bank bank);
    public Optional<Bank> findById(Long id);
}
