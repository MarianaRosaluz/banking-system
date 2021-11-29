package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.model.Bank;
import br.rosaluz.banking.system.model.Institution;
import br.rosaluz.banking.system.repository.BankRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BankServiceImpl implements BankService{

    private BankRepository bankRepository;

    public BankServiceImpl(BankRepository bankRepository) {
        this.bankRepository = bankRepository;
    }

    @Override
    public Bank save(Bank bank){
        return  bankRepository.save(bank);
    }

    @Override
    public Optional<Bank> findById(Long id){
        return bankRepository.findById(id);
    }
}
