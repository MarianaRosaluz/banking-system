package br.rosaluz.banking.system.service;

import br.rosaluz.banking.system.dto.SingInName;
import br.rosaluz.banking.system.model.User;
import br.rosaluz.banking.system.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements  UserService {


    private  UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository){
      this.userRepository = userRepository;
    }


    @Override
    public User saveUser(User user)
    {
         return userRepository.save(user);
    }

    @Override
    public Optional<User> findByLogin(String login){

        return  userRepository.findByLogin(login);

    }

    @Override
    public Optional<User> findById(Long id){
        return  userRepository.findById(id);
    }

    @Override
    public  boolean validateLoginAlredyExist(SingInName login){

        if(findByLogin(login.singInName).isPresent())
            return false;
        else
            return true;
    }


}
