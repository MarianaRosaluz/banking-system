package br.rosaluz.banking.system.repository;

import br.rosaluz.banking.system.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByLogin(String Login);

}
