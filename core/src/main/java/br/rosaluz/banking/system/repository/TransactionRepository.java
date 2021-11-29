package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.Account;
import br.rosaluz.banking.system.model.Payment;
import br.rosaluz.banking.system.model.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    Optional<List<Transaction>> findByaccountNumber(Long accountNumber);
}
