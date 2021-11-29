package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.Institution;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstitutionRepository extends JpaRepository<Institution, Long> {
}
