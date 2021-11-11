package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.SingInName;
import br.rosaluz.banking.system.model.User;

import java.util.Optional;


public interface UserService {

    public User saveUser(User user);
    public Optional<User> findByLogin(String login);
    public Optional<User> findById(Long id);
    public boolean validateLoginAlredyExist(SingInName login);

}
