package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}
