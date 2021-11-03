package br.rosaluz.banking.system.dto;

import br.rosaluz.banking.system.model.User;
import br.rosaluz.banking.system.service.utils.Encrypt;

public class UserDTO {

    private  String name;
    private  String  login;
    private String  password;

    public UserDTO(String name, String login, String password) {
        this.name = name;
        this.login = login;
        this.password = password;
    }

    public User convertToUser(){
        String convert = Encrypt.base64encode(password);
        return  new User(name,login, Encrypt.base64encode(password));
    }
}
