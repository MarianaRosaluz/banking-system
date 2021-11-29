package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long>{
}
