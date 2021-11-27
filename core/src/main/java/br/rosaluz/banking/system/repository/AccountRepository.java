package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.Account;
import br.rosaluz.banking.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Long> {

    Optional<Account> findByaccountNumber(Long Login);
}
