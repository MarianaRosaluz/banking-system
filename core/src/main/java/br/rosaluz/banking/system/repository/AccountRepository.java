package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccountRepository extends JpaRepository<Account, Long> {


}
