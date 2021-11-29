package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
