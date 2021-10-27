package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
